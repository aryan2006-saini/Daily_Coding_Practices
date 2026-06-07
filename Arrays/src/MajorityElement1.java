import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    // return the element whose frequency is strictly greater than floor(arr.length/2)
    // 1. Brute Force
    static int majorityBrute(int[] arr){
        int n = arr.length;
        for (int i = 0; i<n;i++){
            int count = 0;
            for (int j = 0; j<n; j++){
                if (arr[i]==arr[j]) count++;
            }
            if (count>Math.floor(n/2)) return arr[i];
        }
        return -1;
    }
    // 2. Better Approach (Hashing)
    static int majorityBetter(int[] arr){
        int n = arr.length;
        Map<Integer, Integer> map =new HashMap<>();
        for (int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            if (map.get(arr[i])>Math.floor(n/2)) return arr[i];
        }
        return -1;
    }
    // 3. Optimal Approach (Moore's Voting Algorithm)
    static int majorityOptimal(int[] arr){
        int n = arr.length;
        int count = 0;
        int el  = 0;
        for (int i=0; i<n;i++){
            if (count==0){
                count=1;
                el = arr[i];
            }
            else if (arr[i]==el) count++;
            else count--;
        }
        int count1 = 0;
        for (int i = 0; i<n; i++){
            if (arr[i]==el) count1++;
        }
        if (count1>Math.floor(n/2)) return el;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1,2,2};
        int[] arr2 = {2,2,3,3,1,1};
        System.out.println(majorityBrute(arr));
        System.out.println(majorityBrute(arr2));
        System.out.println(majorityBetter(arr));
        System.out.println(majorityBetter(arr2));
        System.out.println(majorityOptimal(arr));
        System.out.println(majorityOptimal(arr2));
    }
}

import java.util.HashMap;
import java.util.Map;
public class AppearedOnceInArray {
    // 1. Brute Force (multiple loops)
    static int findNBrute(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[j]==num) count++;
            }
            if (count == 1) return num;
        }
        return -1;
    }
    // 2. Better Solution (Hashing Array)
    static int findNBetter1(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int i:arr) {
            maxi = Math.max(maxi, i);
        }
        int[] hash = new int[maxi + 1];
        for (int i=0; i<arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i=0; i<arr.length; i++) {
            if (hash[arr[i]] == 1) {
                return arr[i];
            }
        }
        return -1;
    }
    // 3. Better Approach (Using HashMap)
    static int findNBetter2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for (int key:map.keySet()) {
            if (map.get(key)==1) {
                return key;
            }
        }
        return -1;
    }
    // 4. Optimal Approach (Using XOR)
    static int findNOptimal(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findNBrute(arr));
        System.out.println(findNBetter1(arr));
        System.out.println(findNBetter2(arr));
        System.out.println(findNOptimal(arr));
    }
}
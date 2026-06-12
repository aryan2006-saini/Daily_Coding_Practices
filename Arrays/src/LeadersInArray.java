import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    // An element will be leader if all the elements of it's right part are less that that element
    // 1. Brute Force Solution
    static List<Integer> leaadersBrute(int[] arr){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            boolean leader = true;
            for (int j=i+1; j<n; j++){
                if (arr[i]<arr[j]){
                    leader=false;
                    break;
                }
            }
            if (leader==true) res.add(arr[i]);
        }
        return res;
    }

    // 2. Optimal Solution
    static List<Integer> leaderOptimal(int[] arr){
        int maxi = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i=n-1; i>=0; i--){
            if (arr[i]>maxi){
                res.add(arr[i]);
                maxi = arr[i];
            }
        }
        return res.reversed();
    }

    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        System.out.println(leaadersBrute(arr));
        System.out.println(leaderOptimal(arr));
    }
}

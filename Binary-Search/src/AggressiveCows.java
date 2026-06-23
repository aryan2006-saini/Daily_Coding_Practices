import java.util.Arrays;

public class AggressiveCows {
    // max of min pattern
    // arr[]= { 0, 3,  4,  7, 9, 10}, k=4
    //Poss(1)-> c1 c2 c3  c4         ==> 1
    //    (2)-> c1 c2     c3  c4     ==> 2
    //    (3)-> c1 c2     c3      c4 ==> 3
    //    (4) ========================> Not possible
    // range determination:
    // suppose we only have 2 cows to place
    //       -> c1                 c4 ==> (max-min) in sorted array

    // 1. Brute Force
    static int aggressiveCowsBrute(int[] arr, int cows){
        int[] a = arr.clone();
        int n = a.length;
        Arrays.sort(a);
        int to = a[n-1]-a[0];
        for (int i=1; i<to; i++){
            if (canWePlace(arr,i,cows)==true){
                continue;
            }
            else{
                return (i-1);
            }
        }
        return -1;
    }

    // 2. Optimal Approach (Binary Search)
    static int aggressiveCows(int[] arr, int cows){
        int[] ar = arr.clone();
        int n = arr.length;
        Arrays.sort(ar);
        int low = 1, high = ar[n-1]-ar[0];
        while (low<=high){
            int mid = low+(high-low)/2;
            if (canWePlace(ar, mid, cows)==true){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
    // can we place?
    static boolean canWePlace(int[] arr, int distance, int cows){
        int n = arr.length;
        int countCows = 1, lastCow = arr[0];
        for (int i=1; i<n; i++){
            if (arr[i]-lastCow>=distance){
                countCows++;
                lastCow = arr[i];
            }
            if (countCows>=cows) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3,  4,  7, 9, 10};
        int cows = 4;
        System.out.println(aggressiveCowsBrute(arr,cows));
        System.out.println(aggressiveCows(arr,cows));
    }
}

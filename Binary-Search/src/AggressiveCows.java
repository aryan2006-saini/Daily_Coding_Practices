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
        for (int i=1; i<(a[n-1]-a[0]); i++){

        }
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
}

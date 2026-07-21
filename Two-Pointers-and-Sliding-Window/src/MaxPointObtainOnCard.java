public class MaxPointObtainOnCard {
    // Given array of card and integer k, we have to take cards either from left or right or from both side,
    // but in a manner.
    static int maxPoint(int[] arr,int k ){
        int n = arr.length;
        int lSum = 0, rSum = 0, maxSum = 0;

        for (int i=0; i<k; i++){
            lSum += arr[i];
        }
        maxSum = lSum;
        int rIdx = n-1;
        for (int i=k-1; i>=0; i--){
            lSum -= arr[i];
            rSum += arr[rIdx];
            rIdx--;

            maxSum = Math.max(maxSum, lSum+rSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        System.out.println(maxPoint(arr,k));
    }
}

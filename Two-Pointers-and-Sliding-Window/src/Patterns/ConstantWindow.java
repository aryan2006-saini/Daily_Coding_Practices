package Patterns;

public class ConstantWindow {
    // given an array return max window sum of length k
    static int maximumSum(int[] arr, int k){
        int n = arr.length;
        int sum = 0;
        for (int i=0; i<k; i++){
            sum+=arr[i];
        }
        int maxSum = Integer.MIN_VALUE;
        int l = 0, r = k-1;
        while (r<n-1){
            sum -= arr[l];
            l++;
            r++;
            sum+= arr[r];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 3, 4, 5, -1};
        int k = 4;
        System.out.println(maximumSum(arr, k));
    }
}

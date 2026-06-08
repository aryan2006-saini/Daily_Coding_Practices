public class MaxSubArraySum {
    // int[] arr = {-2,-3,4,-3,1,5,-3}, ans =7;
    // 1. Brute Force (Loops)
    static int maxSubSumBrute(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i=0; i<n;i++){
            for (int j=i;j<n; j++){
                int sum = 0;
                for (int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    // 2. Better Approach (Optimized Brute Force)
    static int maxSubSumBetter(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i=0; i<n;i++){
            int sum = 0;
            for (int j=i;j<n; j++){
                sum+=arr[j];
            }
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }

    //3 Optimized Approach (Kadane's Algorithm)
    // (1) return the sum:
    static int maxSubSumOptimized1(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            if (sum>maxi) maxi = sum;
            if (sum<0) sum=0;
        }
        return maxi;
    }
    // (2) return the subarray
    static int[] maxSumSubArray(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start=-1;
        int maxStart=-1;
        int maxEnd = -1;
        for (int i=0; i<n;i++){
            if (sum==0) { start=i;
            }
            sum+=arr[i];
            if (sum>maxi){
                maxi=sum;
                maxStart=start;
                maxEnd=i;
            }
            if(sum<0) sum=0;
        }
        int[] res= new int[maxEnd-maxStart+1];
        for (int i=maxStart;i<=maxEnd;i++){
            res[i-maxStart]=arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-3,1,5,-3};
        System.out.println(maxSubSumBrute(arr));
        System.out.println(maxSubSumBetter(arr));
        System.out.println(maxSubSumOptimized1(arr));
        System.out.println();
        int res[] = maxSumSubArray(arr);
        for (int i:res){
            System.out.print(i+" ");
        }
    }
}

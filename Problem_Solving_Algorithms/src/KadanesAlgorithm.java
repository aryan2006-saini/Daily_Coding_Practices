public class KadanesAlgorithm {
    //  int[] arr = {-2,-3,4,-3,1,5,-3}, ans =7;
    // take maximum sum = Integer minimum value.
    // take a variable sum as 0 and iterate through array
    // if sum>maximum sum -> assign maximum sum as sum
    // if sum<0 -> reinitialize the sum as 0

    //         maxi = Integer.MIN_VALUE;
    //        int[] arr = {-2,-3       ,4,       -3,       1,           5,      -3}
    //                     /  /          \         \        \           \         \
    //                   (sum<0)       (sum=4)   (sum=1>0)  (sum=2>0)  (sum=7>0) (sum=4)
    //             (maxi=not changed)  (maxi=4)  (maxi=4)   (maxi=4)   (maxi=7)  (maxi=7)<-ans

    // V1-> return the max sum
    static int maxSubArraySum(int[] arr){
        int n = arr.length;
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0; i<n;i++){
            sum+=arr[i];
            if (sum>maxi) maxi=sum;
            if (sum<0) sum=0;
        }
        return maxi;
    }
    // V2-> return the array itself with max sum
    static int[] maxSumSubArray(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start=0;
        int maxStart = -1;
        int maxEnd = -1;
        for (int i=0; i<n;i++){
            if (sum==0) start=i;
            sum+=arr[i];
            if (sum>maxi){
                maxi=sum;
                maxStart=start;
                maxEnd=i;
            }
            if (sum<0) sum=0;
        }
        int[] res = new int[maxEnd-maxStart+1];
        for (int i=maxStart;i<=maxEnd;i++){
            res[i-maxStart]=arr[i];
        }
        System.out.println("Max-Sum: "+ maxi);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-3,1,5,-3};
        System.out.println(maxSubArraySum(arr));
        int[] res = maxSumSubArray(arr);
        for (int i:res){
            System.out.print(i+" ");
        }
    }
}

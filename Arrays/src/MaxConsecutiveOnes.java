public class MaxConsecutiveOnes {
    // it is a straight forward problem
    static int maxConsOnes(int[] arr){
        int n = arr.length;
        int count=0, max1=0;
        for (int i=0; i<n;i++){
            if (arr[i]==1){
                count++;
                max1 = Math.max(max1,count);
            }else{
                count=0;
            }
        }
        return max1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,0,0,1,1,1,0,0,1,1};
        System.out.println(maxConsOnes(arr));
    }
}

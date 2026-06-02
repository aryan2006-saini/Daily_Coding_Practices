public class LeftRotateByK {
    // arr = [1,2,3,4,5,6,7], k = 3
    // output=[4,5,6,7,1,2,3]

    // 1. Brute Force
    static void leftRotateBrute(int[] arr, int k){
        int n = arr.length;
        k = k%n;  // for taking care of multiple of Ks.
        int[] temp = new int[k];
        // copy first k elements
        for(int i=0; i<k; i++){
            temp[i]=arr[i];
        }
        // shift left the left elements
        for (int i=k; i<n; i++){
            arr[i-k]=arr[i];
        }
        // fill the right positions to temp elements
        for (int i=n-k; i<n; i++){
            arr[i]=temp[i-(n-k)];
        }
    }

    // 2. Optimal approach
    static void leftRotateBetter(int[] arr, int k){
        int n= arr.length;
        k = k%n;
        // reverse the first k elements
        reverse(arr,0,k-1);
        // reverse next n-k elements
        reverse(arr,k,n-1);
        // now reverse the whole array
        reverse(arr,0,n-1);
    }
    static void reverse(int[] arr, int i, int j){
        while (i<=j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[]  arr = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.print("Before Rotation: ");
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
        leftRotateBrute(arr, k);
        System.out.print("After Rotation by k places: ");
       for (int i:arr){
           System.out.print(i+" ");
       }
        System.out.print("\nRotate the rotated array by k places: ");
       leftRotateBetter(arr,k);
        for (int i: arr){
            System.out.print(i+" ");
        }

    }
}

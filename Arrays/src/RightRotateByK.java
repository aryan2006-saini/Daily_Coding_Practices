public class RightRotateByK {
    // arr[]={1 2 3 4 5 6 7}, k=3
    // output=[5,6,7,1,2,3,4]

    // 1. Brute Force
    static void rightRotateBrute(int[] arr, int k){
        int n = arr.length;
        k = k%n;
        int[] temp = new int[k];
        for (int i=n-k; i<n; i++){
            temp[i-(n-k)]=arr[i];
        }
        for (int i=n-k-1;i>=0; i--){
            arr[i+k]=arr[i];
        }
        for (int i=0;i<k;i++){
            arr[i]=temp[i];
        }
    }

    // 2. Optimal approach
    static void rightRotateOptimal(int[] arr, int k){
        int n = arr.length;
        k = k%n;
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-k-1);
        reverse(arr,0,n-1);
    }
    static void reverse(int[] arr, int i, int j){
        while (i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.print("Before Rotation: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.print("\nAfter Rotation: ");
        rightRotateBrute(arr,k);
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("\nAgain rotate: ");
        rightRotateOptimal(arr,4);
        for (int i: arr){
            System.out.print(i+" ");
        }
    }
}

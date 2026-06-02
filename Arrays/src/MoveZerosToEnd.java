import java.util.Arrays;

public class MoveZerosToEnd {
    // 1. Brute Force
    static void moveZerosBrute(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        Arrays.fill(temp,0);
        int i=0;
        for (int j:arr){
            if (j!=0){
                temp[i]=j;
                i++;
            }
        }
        for (int k = 0; k<n; k++){
            arr[k]=temp[k];
        }
    }

    // 2. Optimal Solution
    static void moveZerosOprimal(int[] arr){
        int n= arr.length;
        int j = -1;
        // find the index of zero
        for (int i=0; i<n; i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for (int i=j+1; i<n;i++){
            if (arr[i]!=0){
                swap(arr, j, i);
                j++;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        moveZerosOprimal(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }

    }
}

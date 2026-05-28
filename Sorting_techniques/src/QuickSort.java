public class QuickSort {
    static void sort(int[] arr){
        int n = arr.length;
        quickSort(arr,0,n-1);
    }

    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot_idx = findPivot(arr, low, high);
            quickSort(arr,low,pivot_idx-1);
            quickSort(arr,pivot_idx+1,high);
        }
    }

    static int findPivot(int[] arr, int low, int high){
        int pivot = arr[low];
        int i=low;
        int j = high;

        while(i<j){
            while( i<=high && arr[i]<=pivot){
                i++;
            }
            while(j>=low && arr[j]>pivot){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {35,57,2,2,4,12,34,6};
        System.out.print("Before Sorting: ");
        for (int i: arr){
            System.out.print(i+" ");
        }

        sort(arr);

        System.out.print("\nAfter Sorting: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}

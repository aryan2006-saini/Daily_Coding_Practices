import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    static void mergeSort(int[] arr){
        int n=arr.length;
        mSort(arr,0,n-1);

    }
    static void mSort(int[] arr, int low, int high){
        if (low>=high) return;
        int mid = low + (high-low)/2;

        mSort(arr, low, mid);
        mSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }

    static void  merge(int[] arr,int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k = 0;
        while (left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k]=arr[left];
                left++;
            }
            else{
                temp[k]=arr[right];
                right++;
            }
            k++;
        }
        while(left<=mid){
            temp[k]=arr[left];
            left++;
            k++;
        }
        while(right<=high){
            temp[k]=arr[right];
            right++;
            k++;
        }

        for (int i = low; i <= high; i++) {
            arr[i]= temp[i - low];
        }
    }

    public static void main(String[] args) {
        int[] arr= {6,4,6,25,8,96,29,58};
        System.out.print("Before Sorting: ");
        for(int i: arr){
            System.out.print(i+" ");
        }

        mergeSort(arr);
        System.out.print("\nAfter Sorting: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

}

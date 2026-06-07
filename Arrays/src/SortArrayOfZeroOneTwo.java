import java.util.Arrays;

public class SortArrayOfZeroOneTwo {
    // 1. Brute Force(Use any of Sorting)
    static int[] sortZOTBrute(int[] arr){
        int[] temp = arr.clone();
        int n = temp.length;
        mergeSort(temp,0,n-1);
        return temp;
    }
    static void mergeSort(int[] arr, int low, int high){
        if (low>=high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    static void  merge(int[] arr,int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        while (left <= mid) {
            temp[k] = arr[left];
            left++;
            k++;
        }
        while (right <= high) {
            temp[k] = arr[right];
            right++;
            k++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    // 2. Better Solution (Counters)
    static int[] sortZOTBetter(int[] arr){
        int[] temp = arr.clone();
        int count0 = 0, count1=0, count2=0;
        for (int i=0; i<temp.length; i++){
            if (temp[i]==0) count0++;
            else if (temp[i]==1) count1++;
            else count2++;
        }
        for (int i=0; i<count0;i++) temp[i]=0;
        for (int i=count0; i<count1;i++) temp[i]=1;
        for (int i=count1;i<count2;i++) temp[i]=2;
        return temp;
    }

    // 3. Optimal Solution (Dutch-National Flag Algorithm)
    static void sortZOTOptimal(int[] arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while (mid<=high){
            if (arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid]==1) mid++; //already sorted
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        int[] res = sortZOTBrute(arr);
        for (int i:res){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res1 = sortZOTBetter(arr);
        for (int i:res){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] temp = arr.clone();
        sortZOTOptimal(temp);
        for (int i: temp){
            System.out.print(i+" ");
        }
    }
}

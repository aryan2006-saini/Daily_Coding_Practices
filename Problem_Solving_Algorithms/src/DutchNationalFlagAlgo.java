public class DutchNationalFlagAlgo {
    // format: [0....low-1] [low....mid-1]                      [mid.....high]     [high....high+1]
    //         /        /     /        /                         /          /         /          /
    //        0 0 0 0..0     1 1 1 ... 1 (till here sorted)|    2/0/1/2(unsorted)    2 2 ...... 2 (sorted)
    //
    // if (arr[mid]==0) --> swap(low, mid) and move low++, mid++
    // if (arr[mid]==1) --> till [0,mid] it will be already sorted mid++;
    // if (arr[mid]==2) --> swap(mid, high) only high--;

//    three pointers , low=0, mid = 0, high =n-1;
//            low
//             /
//    arr[] = [0,1,2,0,1,2,1,2,0,0,0,1]
//             \                      \
//              mid                   high

    static void sortZOT(int[] arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while (mid<=high){
            if (arr[mid]==0){
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if (arr[mid]==1) mid++;
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,0,1,2,1,2,0,0,0,1};
        sortZOT(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}

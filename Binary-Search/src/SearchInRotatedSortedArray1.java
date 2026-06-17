public class SearchInRotatedSortedArray1 {
    // no duplicate will be there
    // arr[] = { 5,6,7,1,2,3,4}, target = 3
    // ans = 5
    static int search(int[] arr, int target){
        int n = arr.length;
        int low =0;
        int high = n-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target) return mid;
            // left half
            if (arr[low]<=arr[mid]){
                if (arr[low]<=target && target<=arr[high]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // right half
            else{
                if (arr[mid]<=target && target<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4};
        int  target = 3;
        System.out.println(search(arr,target));
    }
}

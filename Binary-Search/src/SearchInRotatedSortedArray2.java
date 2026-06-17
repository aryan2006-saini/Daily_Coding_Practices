public class SearchInRotatedSortedArray2 {
    // duplicate will be there
    // arr[] = { 5,6,6,7,1,1,1,2,2,3,4}, target = 3
    // ans = true
    static boolean search(int[] arr, int target){
        int n = arr.length;
        int low =0;
        int high = n-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target) return true;
            // shrink the search space
            // case-> [3,1,2,3,3,3,3]
            if (arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
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
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 5,6,6,7,1,1,1,2,2,3,4};
        int  target = 0; //false;
        System.out.println(search(arr,target));
    }
}

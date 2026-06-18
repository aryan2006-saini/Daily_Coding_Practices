public class PeakElement {
    // 1. For one peak
    static int peak(int[] arr){
        int n = arr.length;
        if (n==1) return 0;
        if (arr[0]>arr[1]) return 0;
        if (arr[n-1]>arr[n-2]) return n-1;
        int low = 1, high = n-2;
        while (low<=high){
            int mid = low + (high-low)/2;
            // if mid is on the peak
            if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            // if mid is left side of the peak
            else if (arr[mid]>arr[mid-1]) low = mid+1;
            // if mid is on the right side of peak
            else if (arr[mid]>arr[mid+1]) high = mid-1;
        }
        return -1;
    }
    // 2. multiple peaks
    static int findPeak(int[] arr){
        int n = arr.length;
        if (n==1) return 0;
        if (arr[0]>arr[1]) return 0;
        if (arr[n-1]>arr[n-2]) return n-1;
        int low = 1, high = n-2;
        while (low<=high){
            int mid = low + (high-low)/2;
            // if mid is on the peak
            if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
                // if mid is left side of the peak
            else if (arr[mid]>arr[mid-1]) low = mid+1;
                // if mid is on the right side of the peak.
            else if (arr[mid]>arr[mid+1]) high = mid-1;

            // what is mid is stuck in the minima like V-curve.
            // to get rid of this, move the low or high pointer
            // low = mid+1 or high = mid-1;
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,8,5,1};
        System.out.println(peak(arr));
        int[] arr1 = {2,3,4,9,3,4,5,8,5,1};
        System.out.println(findPeak(arr1));
    }
}

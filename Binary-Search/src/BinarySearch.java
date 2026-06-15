public class BinarySearch {
    //iterative
     static int iterative(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    // recursive
    static int recursive(int[] arr, int low, int high, int target){
         if (high<low) return -1;
         int mid = low+(high-low)/2;
         if (arr[mid]==target) return mid;
         else if (arr[mid]<target) return recursive(arr,mid+1, high, target);
         else return  recursive(arr, low, mid-1,target);
    }

    public static void main(String[] args) {
        int[] arr= {1,2,4,6,7,7,8,9,10};
        int target = 7;
        System.out.println(iterative(arr,target));
        System.out.println(recursive(arr,0,arr.length-1,target));
    }
}

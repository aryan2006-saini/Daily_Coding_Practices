public class UpperBound {
    // smallest index such that arr[index]>x
    static int upperBoundBrute(int[] arr, int x){
        int n = arr.length;
        int res = n;
        for (int i = 0; i<n; i++){
            if (arr[i]>x){
                res = i;
                break;
            }
        }
        return res;
    }
    // Using Binary Search
    static int upperBound1(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1;
        int res = n;
        while (low<=high){
            int mid = low +(high-low)/2;
            if (arr[mid]>x){
                res = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return res;
    }
    // without taking extra res variable
    static int upperBound2(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1;
        while (low<=high){
            int mid = low +(high-low)/2;
            if (arr[mid]>x){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,5,6,6,6,7,7,8};
        int x=6;
        System.out.println(upperBoundBrute(arr,x));
        System.out.println(upperBound1(arr,x));
        System.out.println(upperBound2(arr,x));
    }
}

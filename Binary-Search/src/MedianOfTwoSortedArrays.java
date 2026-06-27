public class MedianOfTwoSortedArrays {
    // arr1 = { 1, 3, 4, 7, 10, 12 }
    // arr2 = { 2, 3, 6, 15 }
    // ans = 5

    // 1. Brute Force
    static int medianBrute(int[] a, int[] b){
        int n1 = a.length, n2 = b.length, n = n1+n2;
        int[] res = new int[n];
        int i = 0, j=0, k=0;
        while (i<n1 && j<n2){
            if (a[i]<b[j]) res[k++]=a[i++];
            else res[k++]=b[j++];
        }
        while (i<n1){
            res[k++]=a[i++];
        }
        while (j<n2){
            res[k++]=b[j++];
        }
        if (n%2==1) return res[n/2];
        else return (res[n/2]+res[n/2-1])/2;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 7, 10, 12 };
        int[] arr2 = { 2, 3, 6, 15 };
        System.out.println(medianBrute(arr1,arr2));
    }
}

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
    // 2. Better Approach
    static int medianBetter(int[] a, int[] b){
        int n1 = a.length, n2 = b.length, n = n1+n2;
        int i = 0, j=0, count = 0;
        int idx1el=-1, idx2el=-1;
        while (i<n1 && j<n2){
            if (a[i]<b[j]){
                if (count==idx1el) idx1el=a[i];
                if (count==idx2el) idx2el=a[i];
                count++;
                i++;
            }
            else{
                if (count==idx1el) idx1el=b[j];
                if (count==idx2el) idx2el=b[j];
                count++;
                j++;
            }
        }
        while (i<n1){
            if (count==idx1el) idx1el=a[i];
            if (count==idx2el) idx2el=a[i];
            count++;
            i++;
        }
        while (j<n2){
            if (count==idx1el) idx1el=b[j];
            if (count==idx2el) idx2el=b[j];
            count++;
            j++;
        }
        if (n%2==1) return idx2el;
        else{
            return (idx1el+idx2el)/2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 7, 10, 12 };
        int[] arr2 = { 2, 3, 6, 15 };
        System.out.println(medianBrute(arr1,arr2));
        System.out.println(medianBetter(arr1,arr2));
    }
}

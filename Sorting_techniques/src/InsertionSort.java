public class InsertionSort {
    public static void sort(int[] arr){
        int n = arr.length;
        for (int i=0; i<=n-1;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;

                j--;
                System.out.println("Pass"); // for best case(sorted array) this line will not be printed.
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {84, 73, 45, 26, 7, 0, 46};
        System.out.print("Before Sorting: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(arr1);
        System.out.print("After Sorting: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.println("\n--------");

        int[] arr2 = {2,48,50,59,68,77,88};
        System.out.print("Before Sorting: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(arr2);
        System.out.print("After Sorting: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}

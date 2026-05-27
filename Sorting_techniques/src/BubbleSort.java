public class BubbleSort {
    public static void sort(int[] arr){ // this can go O(n^2) for sorted array.
        int n=arr.length;
        for (int i=n-1; i>=1; i--){
            for (int j = 0; j<=i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void optimalSort(int[] arr){
        int n=arr.length;
        for (int i=n-1; i>=1; i--){
            boolean flag = false;
            for (int j = 0; j<=i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag = true;
                }
            }
            if (flag==false) break;
            System.out.println("Pass");  // if array is already sorted it will not be printed.
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,60,8,1,3,9,29,};
        System.out.print("Before Sorting: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.print("\nAfter Sorting: ");
        sort(arr);
        for(int j: arr){
            System.out.print(j+" ");
        }

        System.out.println();
        System.out.println("---------");
        int[] arr1 = {1,2,4,6,7,8,60,88};
        System.out.print("Before Sorting: ");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.print("\nAfter Sorting: ");
        optimalSort(arr1);
        for(int j: arr1){
            System.out.print(j+" ");
        }

    }
}

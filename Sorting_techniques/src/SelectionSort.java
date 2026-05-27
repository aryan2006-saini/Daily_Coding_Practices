public class SelectionSort {
    public static int[] sort(int[] arr){
        int n = arr.length;
        for (int i=0; i<=n-2; i++){
            int mini = i;
            for (int j=i; j<=n-1; j++){
                if(arr[j]<arr[mini]) mini=j;
            }
            swap(arr,i,mini);
        }
        return arr;
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,7,1,8,0};
        System.out.print("Before Sorting: ");
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("After Sorting: ");
        int[] sorted = sort(arr);
        for (int j:sorted){
            System.out.print(j+" ");
        }

    }
}

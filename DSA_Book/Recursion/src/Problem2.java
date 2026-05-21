public class Problem2 {
//    Given	an	array,	check	whether	the	array	is	in	sorted	order	with	recursion.
    static int isArraySorted(int[] arr, int n){
        if (n==1){
            return 1;
        }
        return arr[n-1]<arr[n-2]?0:isArraySorted(arr,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {10,2,4,5,6,7,8};
        int n=5;
        System.out.println(isArraySorted(arr,n));
    }
}

package Backtracking;

public class Problem3 {
//    Generate	all	the	strings	of	n	bits.	Assume	A[0..n	–	1]	is	an	array	of	size	n.
//    int[] arr = new int[n];
    static void binary(int n){
        int[] arr = new int[n];
        if (n<1){
            System.out.print(arr.toString());
        }
        else{
            arr[n-1]=0;
            binary(n-1);
            arr[n-1]=1;
            binary(n-1);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(binary(5));
//    }
}

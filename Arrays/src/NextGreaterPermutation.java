public class NextGreaterPermutation {
    // 1. Brute force approach
    // (i)- Generate all sorted permutations (Recursion)
    // (ii)- Linear Search
    // (iii)- Find the next index
    // It will have very high time complexity (O(N!*N))

    // 2. Optimal Solution
    // Observation-1 :
    //        arr[] = {2,1,5,4,3,0,0}
    //                     5
    //                   /  \
    //                  /    4
    //                 /      \
    //                /        3
    //               1          \
    //                           2
    //                            \
    //                             1
    //         we have to find this(1) break point
    // Observation-2 :
    //            find someone > this point(1) but is should be the smallest one=>(3)
    // Observation:-3 :
    //         Now arr[]={2,3,_,_,_,_,_)--> try to place remaining elements in sorted order=> means smallest

    static int[] nextGreaterPerm(int[] arr){
        int index = -1;
        int n = arr.length;
        // 1. find out the breaking-point element
        for (int i=n-2; i>=0;i--){
            if (arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        // if (index==-1)=> means array is already sorted in decreasing order ==> just reverse the array
        // [(1,2,3),(1,3,2),(2,1,3),(2,3,1),(3,1,2),(3,2,1)]==> next permutation of last element (3,2,1) will be (1,2,3)
        if (index==-1){
            reverse(arr,0,n-1);
            return arr;
        }

        // 2. find someone > this point(1) but is should be the smallest one=>(3)
        for (int i=n-1;i>index;i--){
            if (arr[i]>arr[index]){
                swap(arr,i,index);
                break;
            }
        }
        // 3. Now arr[]={2,3,_,_,_,_,_)--> try to place remaining elements in sorted order=> means smallest
        reverse(arr,index+1,n-1);
        return arr;

    }
    static void reverse(int[] arr, int i, int j){
        while (i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,11,10,9,8,0};
        nextGreaterPerm(arr);
        for (int i: arr){
            System.out.print(i+" ");
        }
        // output= 4 8 0 5 9 10 11
    }
}

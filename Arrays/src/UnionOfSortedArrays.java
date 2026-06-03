import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfSortedArrays {
    // arr1[]=[1,1,2,3,4,5]
    // arr2[]=[2,3,4,4,5,6]
    // Output: [1,2,3,4,5,6]

    // 1.Brute Force
    static int[] unionBrute(int[] arr1, int[] arr2){
        int n1= arr1.length;
        int n2 = arr2.length;
        Set<Integer> st= new TreeSet<>();
        for (int i=0;i<n1;i++){
            st.add(arr1[i]);
        }
        for(int i=0;i<n2;i++){
            st.add(arr2[i]);
        }
        int[] union = new int[st.size()];
        int i=0;
        for (Integer j:st) {
            union[i++] = j;
        }
        return union;
    }

    // 2.Optimal Approach
    static int[] unionOptimal(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i=0; int j=0;
        List<Integer> union = new ArrayList<>();
        while (i<n1 && j<n2){
            // if smaller element is in array1.
            if (arr1[i]<=arr2[j]){
                // check if the union array is empty or current element is not already in array.
                if (union.size()==0 || union.get(union.size()-1)!=arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            // else if the smaller element in array2.
            else{
                if (union.size()==0 || union.get(union.size()-1)!=arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        // what if the array1 is not exhausted
        while (i<n1){
            if (union.size()==0 || union.get(union.size()-1)!=arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }
        // what if array2 is not exhausted
        while (j<n2){
            if (union.size()==0 || union.get(union.size()-1)!=arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        int[] res = new int[union.size()];
        for (int k=0; k<union.size(); k++){
            res[k]=union.get(k);
        }
        return res;

    }

    public static void main(String[] args) {
        int arr1[]={1,1,2,3,4,5};
        int arr2[]={2,3,4,4,5,6};
        int[] res = unionOptimal(arr1,arr2);
        for (int i: res){
            System.out.print(i+" ");
        }
    }
}

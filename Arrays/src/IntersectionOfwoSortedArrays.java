import java.util.ArrayList;
import java.util.List;

public class IntersectionOfwoSortedArrays {
    // A[] = [1,2,2,3,3,4,5,6]
    // B[] = [2,3,3,5,6,6,7]
    // output = [2,3,3,5,6]

    // 1. Brute Force
    static List<Integer> interSectionBrute(int[] A, int[] B){
        int n1 = A.length; int n2 = B.length;
        int[] visited = new int[Math.min(n1,n2)];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n1;i++){
            for (int j=0; j<n2; j++){
                if (A[i]==B[j] && visited[j]==0){
                    res.add(A[i]);
                    visited[j]=1;  //Make the index visited
                    break;
                }
                if (B[j]>A[i]) break;
            }
        }
        return res;
    }

    // 2. Optimal Approach(Two Pointer)
    static List<Integer> interSectionOptimal(int A[], int B[]){
        int n1 = A.length; int n2 = B.length;
        List<Integer> res = new ArrayList<>();
        int i = 0; int j = 0;
        while(i<n1 && j<n2){
            if (A[i]<B[j]){
                i++;
            }
            else if (A[i]>B[j]){
                j++;
            }
            else{
                res.add(A[i]);
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int  A[] = {1,2,2,3,3,4,5,6};
        int B[] = {2,3,3,5,6,6,7};
        System.out.println(interSectionBrute(A,B));
        System.out.println(interSectionOptimal(A,B));
    }
}

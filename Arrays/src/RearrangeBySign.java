import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {
    // variety-1: When the positives and negatives are equal
    // #(+ve) = #(-ve)

    // 1.1- Brute Force Approach (O(2n) & O(n))
    static int[] arrangeBrute(int[] arr){
        int n = arr.length;
        int[] pos=new int[n/2];
        int[] neg = new int[n/2];
        int pIdx=0, nIdx=0;
        for (int i=0; i<n;i++){
            if (arr[i]>0) pos[pIdx++]=arr[i];
            else neg[nIdx++]=arr[i];
        }
        for (int i=0; i<n/2;i++){
            arr[2*i]=pos[i];
            arr[2*i+1]=neg[i];
        }
        return arr;
    }
    // 1.2- Optimal Solution (O(N) & O(N))
    static int[] arrangeOptimal(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        int pIdx = 0;
        int nIdx = 1;
        for (int i=0; i<n;i++){
            if (arr[i]>0){
                res[pIdx]=arr[i];
                pIdx+=2;
            }
            else{
                res[nIdx]=arr[i];
                nIdx+=2;
            }
        }
        return res;
    }

    // Variety-2: When we do not know about counts of +ve and -ve
    static int[] arrangeV2(int[] arr){
        int n = arr.length;
        List<Integer> pos= new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i=0; i<n;i++){
            if (arr[i]>0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        // if #(+ve)>#(-ve)
        if (pos.size()>neg.size()){
            for (int i=0;i<neg.size();i++){
                arr[2*i]=pos.get(i);   // fill the +ve element till the -ve ends
                arr[2*i+1]=neg.get(i); // fill all the -ve elements
            }
            int idx = 2* neg.size(); // now we are on the index (#(+ve) + #(-ve) = 2*(-ve))
            for (int i = neg.size(); i< pos.size();i++){
                arr[idx++]=pos.get(i);
            }
        }
        else {
            for (int i=0;i<pos.size();i++){
                arr[2*i+1]=neg.get(i);   // fill the -ve element till the +ve ends
                arr[2*i]=pos.get(i); // fill all the +ve elements
            }
            int idx = 2* pos.size(); // now we are on the index (#(+ve) + #(-ve) = 2*(+ve))
            for (int i = pos.size(); i< neg.size();i++){
                arr[idx++]=neg.get(i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-1,4,-2,-5,-7,8};
        int res[] = arrangeBrute(arr.clone());
        for (int i: res){
            System.out.print(i+" ");
        }
        System.out.println();
        int res1[] = arrangeOptimal(arr.clone());
        for (int i: res1){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] arr1 = {-9,2,3,-1,4,-2,-5,-7,8};
        int[] res2= arrangeV2(arr1.clone());
        for(int i:res2){
            System.out.print(i+" ");
        }
    }
}

import java.util.Arrays;
public class MissingNumber {
    // 1. Brute Force Approach(Double loop)
    static int missingNBrute(int[] arr, int n){
        for (int i=1; i<=n; i++){
            int flag = 0;
            for (int j=0; j<n-1;j++){
                if (arr[j]==i){
                    flag  = 1;
                    break;
                }
            }
            if (flag==0) return i;
        }
        return -1;
    }
    // 2. Better Approach (Hashing)
    static int missingNBetter(int[] arr, int n){
        int[] hash = new int[n+1];
        Arrays.fill(hash,0);
        for (int i=0; i<n-1;i++){
            hash[arr[i]]=1;
        }
        for (int i=1; i<=n;i++){
            if (hash[i]==0){
                return i;
            }
        }
        return -1;
    }

    // 3. Optimal Approach (Sum)
    static int missingNOptimal1(int[] arr, int n){
        int s1 = n*(n+1)/2;
        int s2=0;
        for (int i:arr){
            s2+=i;
        }
        return s1-s2;
    }
    // 4. Optimal Approach(XOR)
    static int missingNOptimal2(int[] arr, int n){
        int xored=0;
        for (int i=0; i<n-1;i++){
            xored^=arr[i];
            xored^=(i+1);
        }
        return xored^n;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5};
        int n = 5;
        System.out.println(missingNBrute(arr,n));
        System.out.println(missingNBetter(arr,n));
        System.out.println(missingNOptimal1(arr,n));
        System.out.println(missingNOptimal2(arr,n));
    }
}

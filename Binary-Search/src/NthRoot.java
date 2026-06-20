public class NthRoot {
    static int nthRoot(int n, int m){
        int low = 1, high = m;
        while (low<=high){
            int mid = low+(high-low)/2;
            int midN = func(mid, n,m);
            if (midN==1) return mid;
            else if (midN==0) low=mid+1;
            else high = mid-1;
        }
        return -1;
    }
    static int func(int mid,int n, int m){
        long ans = 1;
        for (int i=1; i<=n; i++){
            ans = ans *mid;
            if (ans>m) return 2;
        }
        if (ans==m) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 125;
        System.out.println(nthRoot(n,m));
    }
}

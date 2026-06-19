public class Sqrt {
    static int sqrt(int n){
        if (n<2) return n;
        int low=1, high=n/2;
        int ans = 0;
        while (low<=high){
            int mid = low + (high-low)/2;
            double val = mid*mid;
            if ((int)val == n){
                return mid;
            }
            else if ((int)val>n) high = mid-1;
            else{
                ans = mid;
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(sqrt(n));
    }
}

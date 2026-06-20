public class KokoEatingBanana {
    // return the minimum integer k such that koko eat can all bananas within h hours
    // piles[] = { 3,   6,    7,   11 }, h = 8;
    // 2b/hr      2hr,  3hr, 4hr, 6hr = 15hr>8 (can't take>8)
    // 3b/hr      1hr,  2hr, 3hr, 4hr = 10hr>8 (can't take>8)
    // 4b/hr      1hr,  2hr, 2hr, 3hr = 15hr<=8 (this is min possible)

    static int minRateOfEatingBanana(int[] piles, int h){
        int n = piles.length;
        int low = 1, high = maxElement(piles);
        while (low<=high){
            int mid = low+(high-low)/2;
            int totalH = calculateTotalH(piles,mid);
            if (totalH<=h) high=mid-1;
            else low = mid+1;
        }
        return low;
    }

    static int maxElement(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for (int i:arr){
            maxi = Math.max(maxi, i);
        }
        return maxi;
    }
    static int  calculateTotalH(int[] arr, int hourly){
        int totalH = 0;
        int n = arr.length;
        for (int i=0; i<n;i++){
            totalH += (arr[i]+hourly-1)/hourly;
        }
        return totalH;
    }

    public static void main(String[] args) {
        int[]  piles = { 3,   6,    7,   11 };
        int h = 8;
        System.out.println(minRateOfEatingBanana(piles,h));
    }
}

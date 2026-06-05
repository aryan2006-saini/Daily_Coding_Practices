import java.util.HashMap;
import java.util.Map;
public class LongestSubarrayWithSumK {
    // 1. Brute Force Approach
    static int longestSubArrBrute(int[] arr, int k){
        int n = arr.length;
        int longest = 0;
        for (int i=0; i<n; i++){
            int s = 0;
            for (int j=i; j<n; j++) {
                s += arr[j];
                if (s == k) longest = Math.max(longest, j - i + 1);
            }
        }
        return longest;
    }
    // 2. Better Approach (Using HashMap)
    static int longestSubArrBetter(int[] arr, int k){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i<n; i++){
            sum+=arr[i];
            if (sum==k) maxLen = i+1;
            int remain = sum-k;
            if (map.containsKey(remain)){
                int len = i-map.get(remain);
                maxLen = Math.max(maxLen,len);
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
    // 3. Optimal Approach (2 Pointers)
    static int longestSubArrOptimal(int[] arr, int k){
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int n = arr.length;
        while (right<n){
            while (left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if (sum==k) maxLen = Math.max(maxLen, right-left+1);
            right++;
            if(right<n) sum+=arr[right];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 8;
        System.out.println(longestSubArrBrute(arr,k));
        System.out.println(longestSubArrBetter(arr,k));
        System.out.println(longestSubArrOptimal(arr,k));
    }
}

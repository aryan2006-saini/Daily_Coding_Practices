import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    // arr[] = {102, 4, 100, 1, 101, 3, 2, 1, 1}
    // res={1,2,3,4}==> 4

    // 1. Brute Force
    static int longestSeqBrute(int[] arr){
        int n = arr.length;
        int longest = 1;
        for (int i=0; i<n;i++){
            int curr = arr[i];
            int count = 1;
            while (linearSearch(arr,curr+1)){
                curr+=1;
                count+=1;
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    static boolean linearSearch(int[] arr, int num){
        int n = arr.length;
        int i = 0;
        while (i<n){
            if (arr[i]==num) return true;
            i++;
        }
        return false;
    }
    // 2. Better Approach (Sorting)
    static int longestBetter(int[] arr){
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int n=temp.length;
        int longest = 1;
        int count = 0;
        int lastSmaller = Integer.MAX_VALUE;
        for (int i=0; i<n;i++){
            if (temp[i]-1==lastSmaller){
                count++;
                lastSmaller=temp[i];
            }
            else if (temp[i]==lastSmaller){
                continue;
            } else if (temp[i]!=lastSmaller) {
                count=1;
                lastSmaller=temp[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    // 3. Optimal Solution
    static int longestConSeq(int[] arr){
        int n = arr.length;
        if (n==0) return 0;
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n;i++){
            set.add(arr[i]);
        }
        for (int i: set){
            if (!set.contains(i-1)){
                int curr = i+1;
                int currLen = 1;
                while (set.contains(curr)){
                    currLen+=1;
                    curr+=1;
                }
                longest = Math.max(longest,currLen);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {102, 4,100,1,101,3,2,1,1};
        System.out.println(longestSeqBrute(arr));
        System.out.println(longestBetter(arr));
        System.out.println(longestConSeq(arr));
    }
}

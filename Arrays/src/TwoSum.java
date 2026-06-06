import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    class Variety1{ // reurn true/false;
        // 1. Brute Force (2-loops)
        static boolean twoSum1Brute(int[] arr,int target){
            int n = arr.length;
            for (int i=0; i<n; i++){
                for (int j=i+1; j<n; j++){
                    if (arr[i]+arr[j]==target) return true;
                }
            }
            return false;
        }
        // Better Approach(using map)
        static boolean twoSum1Better(int[] arr, int target){
            int n = arr.length;
            Map<Integer,Integer> map = new HashMap<>();
            for (int i=0; i<n; i++){
                int a = arr[i];
                int left = target-a;
                if (map.containsKey(left)){
                    return true;
                }
                map.put(a,i);
            }
            return false;
        }
        //Optimal Approach (Sorting+2pointer)
        static boolean twoSum1Optimal(int[] arr, int target){
            int[] temp = arr.clone();
            Arrays.sort(temp);
            int i = 0;
            int j = arr.length-1;
            while (i<j){
                int sum = arr[i]+arr[j];
                if (sum==target) return true;
                else if (sum<target) i++;
                else j--;
            }
            return false;
        }
    }

    class Variety2{
        // 1. Brute Force (2-loops)
        static int[] twoSum2Brute(int[] arr,int target){
            int n = arr.length;
            for (int i=0; i<n; i++){
                for (int j=i+1; j<n; j++){
                    if (arr[i]+arr[j]==target) return new int[]{i+1, j+1};
                }
            }
            return new int[]{-1,-1};
        }

        // Better+Optimal Approach(using map)
        static int[] twoSum2Optimal(int[] arr, int target){
            int n = arr.length;
            Map<Integer,Integer> map = new HashMap<>();
            for (int i=0; i<n; i++){
                int a = arr[i];
                int left = target-a;
                if (map.containsKey(left)){
                   return new int[]{map.get(left)+1, i+1};
                }
                map.put(a,i);
            }
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;
        System.out.println(Variety1.twoSum1Brute(arr,target));
        System.out.println(Variety1.twoSum1Better(arr,target));
        System.out.println(Variety1.twoSum1Optimal(arr,target));
        int[] res = Variety2.twoSum2Brute(arr,target);
        for (int i: res){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res2 = Variety2.twoSum2Optimal(arr, target);
        for (int i: res2){
            System.out.print(i+" ");
        }
    }
}

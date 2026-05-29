import java.util.Arrays;

public class SecondLargest {
    // takes O(nlogn)
    static int sLargestBrute(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int largest = arr[n-1];
        int slargest = -1;
        for (int i=n-2;i>=0; i--){
            if (arr[i]!=largest){
               slargest=arr[i];
                break;
            }
        }
        return slargest;
    }

    // takes O(2n) --> 2 passes to find 2nd Largest
    static int sLargestBetter(int[] arr){
        int n = arr.length;
        int largest=arr[0];
        for(int i:arr){
            if (i>largest){
                largest=i;
            }
        }
        int slargest=-1;
        for (int j:arr){
            if (j>slargest && j<largest){
                slargest=j;
            }
        }
        return slargest;
    }

    //takes O(n) ---> takes only one pass
    static int sLargestOptimal(int[] arr){
        int n = arr.length;
        int largest = arr[0];
        int slargest = -1;

        for (int i: arr){
            if (i>largest){
                slargest=largest;
                largest=i;
            }
            else if (i>slargest && i<largest){
                slargest=i;
            }
        }
        return slargest;
    }


    public static void main(String[] args) {
        int[] arr={1,2,4,7,7,5};
        System.out.println(sLargestBrute(arr));
        System.out.println(sLargestBetter(arr));
        System.out.println(sLargestOptimal(arr));
    }
}

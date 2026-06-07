public class MooresVotingAlgorithm {
    // arr = [7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5]
    // take element 7 and count 0:
    //           -> whenever element is 7 increase the count++;
    //           -> whenever element is other than t decrease count--;
    //           -> lets take a scenario:
    //                     -> arr[] = [7,7,5,7,5,1] and  count=0;
    //                                   /       \
    //                                  d=7       others(5,1)
    //                                (3 times)     (3 times)
    //                                 +++            ---
    //                          (here we can say that 7 will not be majority element)
    // apply same for the other elements.

    static int majorityVotes(int[] arr){
        int n = arr.length;
        int count1 = 0;
        int el=0;
        for (int i=0; i<n;i++){
            if (count1==0){
                count1 = 1;
                el = arr[i];
            }
            if (arr[i]==el) count1++;
            else count1--;
        }
        int count2 = 0;
        for (int i=0; i<n;i++){
            if (arr[i]==el) count2++;
        }
        if (count2>Math.floor(n/2)) return el;
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={7,5,7,7,5};
        System.out.println(majorityVotes(arr));
    }
}
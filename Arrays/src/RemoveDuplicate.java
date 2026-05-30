public class RemoveDuplicate {
    // remove duplicate from sorted array
    static int removeDup(int[] arr){
        int i = 0;
        for (int j=1;j<arr.length; j++ ){
            if (arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return (i+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,4,5,5,6};
        System.out.println(removeDup(arr));
        // Output- 6 , sample array=[1,2,3,4,5,6,_,_,_,_]
    }
}

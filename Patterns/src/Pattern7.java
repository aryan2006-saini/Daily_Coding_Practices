public class Pattern7 {
//              *
//             ***
//            *****
//           *******
//          *********

    static void pattern7(int n){
        for (int i=0; i<n; i++){
            //Space
            for (int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            //Stars
            for (int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            //space
            for (int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        int n=5;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int k = 0; k<2*i+1; k++){
                System.out.print("*");
            }
            for (int l=0; l<n-i-1;l++){
                System.out.print(" ");
            }
            System.out.println();

        }

        pattern7(n);
    }
}

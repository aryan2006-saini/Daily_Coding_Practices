public class Pattern9 {
    static void pattern(int n){
        //Loop for right
        for (int i=0; i<n; i++){
            //spaces
            for (int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            // stars
            for (int j=0; j<2*i+1 ;j++){
                System.out.print("*");
            }
            //spaces
            for (int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        //loop for inversion

        for (int i=n-2; i>=0; i--){
            //spaces
            for (int j=0; j<n-i-1;j++){
                System.out.print(" ");
            }
            //stars
            for (int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            //spaces
            for (int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n=5;
        pattern(n);
    }
}

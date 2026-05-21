public class Pattern17 {
    static void pattern(int n){
        for (int i=0; i<n; i++){
            // space
            for (int j=n-1;j>=i; j--){
                System.out.print(" ");
            }

            // Chars
            for (int j=0; j<=2*n-1; j++){
                System.out.print((char)('A'+j));
                j+=2;
            }

            // spaces

            for (int j = n-1; j>=i; j--){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n=4;
        pattern(n);
    }
}

public class Pattern20 {
    static void pattern(int n){
        int sp=2*n-2;
        for (int i=0; i<n-1; i++){
            for (int j=0; j<=i; j++){
                System.out.print("*");
            }
            for (int j=0; j<sp;j++){
                System.out.print(" ");
            }
            sp-=2;
            for (int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();

        }

        int space=0;
        for (int i=0; i<n;i++){

            for (int j=n-1;j>=i; j--){
                System.out.print("*");
            }
            for (int j=0; j<space; j++){
                System.out.print(" ");

            }
            space+=2;
            for (int j=n-1;j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n=4;
        pattern(n);
    }
}

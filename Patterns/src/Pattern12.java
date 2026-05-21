public class Pattern12 {

//            1        1
//            12      21
//            123    321
//            1234  4321
//            1234554321

    static void pattern(int n){
        int space = 2*n-2;
        for (int i=1; i<=n; i++){
            // stars
            for (int j=1; j<=i; j++){
                System.out.print(j);
            }
            // space
            for (int j=1; j<=space; j++){
                System.out.print(" ");
            }
            // stars
            for (int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
            space-=2;
        }
    }

    public static void main(String[] args) {
        int n=5;
        pattern(n);
    }
}

public class Pattern3 {
    /*
    1
    12
    123
    1234
    12345
     */

    static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<=i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n=2;
        pattern3(n);
    }
}

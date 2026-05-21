public class Pattern4 {
    static void pattern4(int n) {
        /*
        1
        22
        333
        4444
        55555
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print(i + 1);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int n=5;
        pattern4(n);
    }
}

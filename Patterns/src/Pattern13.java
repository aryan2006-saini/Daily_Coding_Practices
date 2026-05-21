public class Pattern13 {
    static void pattern(int n){
//        1
//        2 3
//        4 5 6
//        7 8 9 10
//        11 12 13 14 15
        int fill =0;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                fill+=1;
                System.out.print(fill+" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int n=5;
        pattern(n);
    }
}

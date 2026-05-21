public class Pattern14 {
//    A
//    AB
//    ABC
//    ABCD
//    ABCDE

    static void pattern(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                System.out.print((char)('A'+j)+ " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n=5;
        pattern(n);
    }

}

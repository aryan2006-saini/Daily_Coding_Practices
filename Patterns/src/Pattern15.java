public class Pattern15 {
//    ABCDE
//    ABCD
//    ABC
//    AB
//    A

    static void pattern(int n){
        for (int i=n-1; i>=0; i--){
            for (int j=0;j<=i;j++){
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

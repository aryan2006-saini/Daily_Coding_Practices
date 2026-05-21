public class Pattern18 {

    static void pattern(int n){
        for (int i=n-1; i>=0; i--){
           for (int j=0; j<=i;j++){
               System.out.print((char)('A'+i));
           }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }
}

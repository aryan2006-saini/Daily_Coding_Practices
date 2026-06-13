public class RotateMatrixby90 {
    //  1. Brute Force
    // Observation: 1st row goes to last column, second row goes to second last.....
    // [i][j] ==> [j][n-1-i]
    static int[][] rotateBrute(int[][] matrix){
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                ans[j][n-1-i]=matrix[i][j];
            }
        }
        return ans;
    }

    // 2. Optimal Approach (inplace)
    // idea: transpose the matrix and reverse each row
    static void rotateOptimal(int[][] matrix){
        int n= matrix.length;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                swap(matrix, i, j);
            }
        }
        for (int i=0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    static void reverse(int[] row){
        int n =  row.length;
        int i = 0;
        int j=n-1;
        while (i<=j){
            int temp=row[i];
            row[i]=row[j];
            row[j]=temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans = rotateBrute(matrix);
        for (int i=0; i<ans.length; i++){
            for (int j=0; j<ans[0].length; j++){
                System.out.print(ans[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        rotateOptimal(matrix1);
        for (int i=0; i<matrix1.length; i++){
            for (int j=0; j<matrix1.length; j++){
                System.out.print(ans[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

import java.util.Arrays;

public class SetMatrixZeroes {
    // go to the zero and make entire row and column zero
    // [ 1, 1, 1, 1 ]       [ 1, 0, 0, 1 ]
    // [ 1, 0, 0, 1 ] ==>   [ 0, 0, 0, 0 ]
    // [ 1, 1, 0, 1 ] ==>   [ 0, 0, 0, 0 ]
    // [ 1, 1, 1, 1 ]       [ 1, 0, 0, 1 ]

    // 1. Brute Force (mark -1)
    static void setZeroBrute(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (matrix[i][j]==0){
                    markRow(matrix, i, col);
                    markCol(matrix, row, j);
                }
            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (matrix[i][j]==-1) matrix[i][j]=0;
            }
        }

    }
    static void markRow(int[][] matrix,int row, int col ){
        for (int j=0; j<col; j++){
            if (matrix[row][j]!=0){
                matrix[row][j]=-1;
            }
        }
    }
    static void markCol(int[][] matrix,int row, int col){
        for (int i=0;i<row; i++){
            if (matrix[i][col]!=0){
                matrix[i][col]=-1;
            }
        }
    }

    // 2. Better Solution
    static void setZeroBetter(int[][] matrix){
        int rows= matrix.length;
        int cols = matrix[0].length;
        int[] row = new int[rows];
        int[] col = new int[cols];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 3. Optimal Approach (in-place marking)
    static void setZeroOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col1 = 1;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    if (j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col1=0;
                    }
                }
            }
        }
        for (int i=1; i<rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j]!=0){
                    if (matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if (matrix[0][0]==0){
            for (int j=0; j<cols; j++) matrix[0][j]=0;
        }
        if (col1==0){
            for (int i=0; i<rows; i++) matrix[i][0]=0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int[][] mcopy = matrix.clone();
        setZeroBrute(mcopy);
        for (int i=0; i<mcopy.length; i++){
            for (int j=0; j<mcopy[0].length; j++){
                System.out.print(mcopy[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] matrix1 = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int[][] mcopy1 = matrix1.clone();
        setZeroBetter(mcopy1);
        for (int i=0; i<mcopy1.length; i++){
            for (int j=0; j<mcopy1[0].length; j++){
                System.out.print(mcopy1[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] matrix2 = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int[][] mcopy2 = matrix2.clone();
        setZeroOptimal(mcopy2);
        for (int i=0; i<mcopy2.length; i++){
            for (int j=0; j<mcopy2[0].length; j++){
                System.out.print(mcopy2[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

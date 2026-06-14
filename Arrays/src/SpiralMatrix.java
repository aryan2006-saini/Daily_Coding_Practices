import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // [ 1, 2, 3 ]
    // [ 8, 9, 4 ] ===>> [1,2,3,4,5,6,7,8,9]
    // [ 7, 6, 5 ]

    static List<Integer> spiral(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, bottom = n-1;
        int left = 0, right = m-1;
        while (left<=right && top<=bottom){
            // left to right
            for (int i = left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            // top to bottom
            for (int i = top; i<=bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            // right to left
            if (top<=bottom) {      // edge case for having one row only
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom to top
            if (left<=right) {      // edge case for when we will ben in the middle of matrix
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(spiral(matrix));
    }
}

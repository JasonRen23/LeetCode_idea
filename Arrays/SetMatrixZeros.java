package LeetCode_idea.Arrays;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void setZeros(int[][] matrix){
        final int m = matrix.length;
        final int n = matrix[0].length;
        if(m < 1 || n < 1) return;
        boolean row_has_zero = false;
        boolean col_has_zero = false;
        int i, j;
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    if(i == 0) row_has_zero = true;
                    if(j == 0) col_has_zero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(i = 1; i < m; ++i){
            if(matrix[i][0] == 0){
                for(j = 1; j < n; ++j)
                    matrix[i][j] = 0;
            }
        }

        for(j = 1; j < n; ++j){
            if(matrix[0][j] == 0){
                for(i = 1; i < m; ++i)
                    matrix[i][j] = 0;
            }
        }

        if(row_has_zero){
            for(j = 0; j < n; ++j)
                matrix[0][j] = 0;
        }

        if(col_has_zero){
            for(i = 0; i < m; ++i)
                matrix[i][0] = 0;
        }


    }

    public static void main(String[] args) {
        int[][] matrix1 = { {1, 2, 3},
                            {1, 0, 5},
                            {7, 8, 9}
                            };
        setZeros(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }
}

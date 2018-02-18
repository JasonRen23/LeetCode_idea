package LeetCode_idea.Arrays;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        if(n == 1) return;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                swap(matrix, i, j, j, i);
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n/2; ++j){
                swap(matrix, i, j, i, n - 1 -j);
            }
        }


    }

    public final static void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { {1,2,3},
                            {4,5,6},
                            {7,8,9} 
                            };
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = { { 5, 1, 9,11},
                            { 2, 4, 8,10},
                            {13, 3, 6, 7},
                            {15,14,12,16}
        };
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}

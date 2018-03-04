package LeetCode_idea.DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    // 时间复杂度O(n^2)，空间复杂度O(n^2)
    public static int minPathSum_1(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        final int m = grid.length;
        final int n = grid[0].length;


        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                f[i][j] = f[i - 1][j] + grid[i][j];
            }
        }

        for(int i = 0; i < m; ++i){
            for(int j = 1; j < n; ++j){
                f[i][j] = f[i][j - 1] + grid[i][j];
            }
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];

    }
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public static int minPathSum_2(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        final int m = grid.length;
        final int n = grid[0].length;

        int[] f = new int[n];
//        f[0] = grid[0][0];
        Arrays.fill(f,Integer.MAX_VALUE);// 初始值是 INT_MAX，因为后面用了min函数, 用于第一行的更新,可用下述代码代替
//        for(int i = 1; i < n; i++){
//            f[i] = f[i - 1] + grid[0][i];
//        }


        f[0] = 0;

        for(int i = 0; i < m; i++){
            f[0] += grid[i][0];
            for(int j = 1; j < n; ++j){
                // 左边的f[j]，表示更新后的f[j]，与公式中的f[i[[j]对应
                // 右边的f[j]，表示老的f[j]，与公式中的f[i-1][j]对应
                f[j] = Math.min(f[j - 1], f[j]) + grid[i][j];
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1}
//                {4,2,1}
        };
        System.out.println(minPathSum_1(grid));
        System.out.println(minPathSum_2(grid));
    }
}

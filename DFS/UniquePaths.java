package LeetCode_idea.DFS;

public class UniquePaths {
    // 时间复杂度O(n^2)，空间复杂度O(n^2)
    public static int uniquePaths_1(int m, int n){
        int[][] f = new int[m][n];
        f[0][0] = 1;

        return dfs(f, m - 1, n - 1);
    }

    public static int dfs(int[][] f, int x, int y){
        if(x < 0 || y < 0) return 0;
        if(x == 0 && y == 0) return f[0][0];

        if(f[x][y] > 0){
            return f[x][y];
        }else {
        return  f[x][y] = dfs(f, x - 1, y) + dfs(f, x, y - 1);
        }
    }
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public static int uniquePaths_2(int m, int n){
        int[] f = new int[n];
        f[0] = 1;
        for(int i = 0; i < m; ++i){
            for(int j = 1; j < n; ++j){
                // 左边的f[j]，表示更新后的f[j]，与公式中的f[i][j]对应
                // 右边的f[j]，表示老的f[j]，与公式中的f[i-1][j]对应
                f[j] = f[j] + f[j - 1];
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths_1(3, 7));
        System.out.println(uniquePaths_2(3, 7));
    }
}

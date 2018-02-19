package LeetCode_idea.Arrays;

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int lives = 0;
                //上边
                if(i > 0){
                    lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
                }
                //左边
                if(j > 0){
                    lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
                }
                //下边
                if(i < m - 1){
                    lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
                }
                //右边
                if(j < n - 1){
                    lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
                }
                //左上角
                if(i > 0 && j > 0){
                    lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
                }
                //右下角
                if(i < m - 1 && j < n - 1){
                    lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
                }
                //右上角
                if(i > 0 && j < n - 1){
                    lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
                }
                //左下角
                if(i < m - 1 && j > 0){
                    lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
                }
                //根据周边存活数量更新当前点，结果是0和1的不用更新
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 3;
                }else if(board[i][j] == 1 && (lives > 3 || lives < 2)){
                    board[i][j] = 2;
                }

            }
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                board[i][j] %= 2;
            }
        }
    }

    public static void gameOfLife_2(int[][] board){
        if(board == null || board.length < 1) return;
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int lives = liveNeighbors(board, m, n, i, j);

                if(board[i][j] == 1 && (lives == 3 || lives == 2)){
                    board[i][j] = 3;
                }

                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                board[i][j] >>= 1;
            }
        }
    }

    private static int liveNeighbors(int[][] board, int m, int n, int i, int j){
        int lives = 0;
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); ++x){
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); ++y){
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,1,1,0},
                {0,1,0,1,0},
                {1,1,0,1,1},
                {0,1,1,1,0}};
        gameOfLife(board);
        System.out.println("The next state is " + Arrays.deepToString(board));

        int[][] board1 = {{0,0,1,1,0},
                {0,1,0,1,0},
                {1,1,0,1,1},
                {0,1,1,1,0}};
        gameOfLife_2(board1);
        System.out.println("The next state is " + Arrays.deepToString(board1));
    }
}

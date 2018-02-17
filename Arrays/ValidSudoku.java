package LeetCode_idea.Arrays;

import java.util.HashSet;

public class ValidSudoku {
    //30ms
    public static boolean isValidSudoku(char[][] board){
        for(int i = 0; i < 9; ++i){
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] grid = new boolean[9];
            for(int j = 0; j < 9; ++j){
                if(board[i][j] != '.'){
                    int rowIndex = board[i][j] - '1';
                    if(!row[rowIndex]){
                        row[rowIndex] = true;
                    }else{
                        return false;
                    }
                }
                if(board[j][i] != '.'){
                    int colIndex = board[j][i] - '1';
                    if(!col[colIndex]){
                        col[colIndex] = true;
                    }else{
                        return false;
                    }
                }
                int rowIndex = 3*(i/3)+j/3;
                int colIndex = 3*(i%3)+j%3;

                if(board[rowIndex][colIndex] != '.'){
                    int gridIndex = board[rowIndex][colIndex] - '1';
                    if(!grid[gridIndex]){
                        grid[gridIndex] = true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //35ms
    public static boolean isValidSudoku_2(char[][] board){

        for(int i = 0; i < 9; ++i){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> grid = new HashSet<>();
            for(int j = 0; j < 9; ++j){
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                int rowIndex = 3*(i/3) + (j/3);
                int colIndex = 3*(i%3) + (j%3);
                if(board[rowIndex][colIndex] != '.' && !grid.add(board[rowIndex][colIndex]))
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},
        {'2','.','.','.','.','.','.','.','.'},
        {'3','.','.','.','.','.','.','.','.'},
        {'4','.','.','.','.','.','.','.','.'},
        {'5','.','.','.','.','.','.','.','.'},
        {'6','.','.','.','.','.','.','.','.'},
        {'7','.','.','.','.','.','.','.','.'},
        {'8','.','.','.','.','.','.','.','.'},
        {'9','.','.','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku_2(board));
    }
}

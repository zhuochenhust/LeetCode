package backtracking;

public class SudokuSolver_037 {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        helper(board);
    }
    
    public boolean helper (char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num ++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char num) {
        for (int row = 0; row < 9; row ++) {
            if (board[row][j] == num) 
                return false;
        }
        for (int col = 0; col < 9; col ++) {
            if (board[i][col] == num)
                return false;
        }
        for (int m = 0; m < 3; m ++) {
            for (int n = 0; n < 3; n ++) {
                int tmpRow = i / 3 * 3 + m;
                int tmpCol = j / 3 * 3 + n;
                if (board[tmpRow][tmpCol] == num){
                    return false;
                }
            }
        }
        return true;
    }
}

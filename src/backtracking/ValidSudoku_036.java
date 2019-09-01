package backtracking;

import java.util.HashSet;

public class ValidSudoku_036 {
	public boolean isValidSudoku(char[][] board) {
        int row = board.length, column = board[0].length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            set.clear();
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                if (board[i][j] - '0' < 1 || board[i][j] - '0' > 9) // 很容易忘记
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < column; j++) {
            set.clear();
            for (int i = 0; i < row; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                if (board[i][j] - '1' < 0 || board[i][j] - '0' > 9)
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < row / 3; i++) {
            for (int j = 0; j < column / 3; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int tmpRow = i * 3 + k;
                        int tmpColumn = j * 3 + l;
                        if (board[tmpRow][tmpColumn] == '.')
                            continue;
                        if (set.contains(board[tmpRow][tmpColumn]))
                            return false;
                        if (board[tmpRow][tmpColumn] - '0' < 1 || board[tmpRow][tmpColumn] - '0' > 9)
                            return false;
                        set.add(board[tmpRow][tmpColumn]);
                    }
                }
            }
        }
        return true;
    }
}

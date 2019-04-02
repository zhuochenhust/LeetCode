package backtracking;

public class WordSearch_079 {
	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (helper(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, boolean[][] used, int i, int j, int idx) {
        // 1.idx已经走了word长度那么多的步数，代表整个word都按顺序成功被访问到了，return true
        if (idx == word.length()) return true; 
    // 2.(i, j)这个位置已经不在board范围内了，越界了，那肯定找不到了，return false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) return false;
        char[] cs = word.toCharArray();
        // 3.(i, j)这个位置已经被访问过了或者board[i][j]压根不等于我们目前在寻找的目标字符cs[idx]，返回false
        if (used[i][j] == true || board[i][j] != cs[idx]) return false;

        
        used[i][j] = true;
        // up
        if (helper(board, word, used, i + 1, j, idx + 1)) return true;
        // down
        if (helper(board, word, used, i - 1, j, idx + 1)) return true;
        // left
        if (helper(board, word, used, i, j - 1, idx + 1)) return true;
        // right
        if (helper(board, word, used, i, j + 1, idx + 1)) return true;
        used[i][j] = false;
        return false;
    }
}

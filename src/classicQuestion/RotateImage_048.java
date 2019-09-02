package classicQuestion;

public class RotateImage_048 {
	public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        while (n > 0) {
            for (int i = 0; i < n - 1; i ++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            n -= 2;
            top ++;
            left ++;
            bottom --;
            right --;
        }
    }
}	

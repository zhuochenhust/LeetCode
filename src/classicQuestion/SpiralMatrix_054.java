package classicQuestion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_054 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1; 
        while (left < right && top < bottom) {
            for (int i = left; i < right; i ++) res.add(matrix[top][i]);
            for (int i = top; i < bottom; i ++) res.add(matrix[i][right]);
            for (int i = right; i > left; i --) res.add(matrix[bottom][i]);
            for (int i = bottom; i > top; i --) res.add(matrix[i][left]);
            left ++;
            right --;
            top ++;
            bottom --;
        }
        if (top == bottom) {
            for (int i = left; i <= right; i ++) {
                res.add(matrix[top][i]);
            }
        } else if (left == right) { 
            // 这里一定要写else if，因为top == bottom && left == right 这种情况都被上面top == bottom情况包含了
            for (int i = top; i <= bottom; i ++) {
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}

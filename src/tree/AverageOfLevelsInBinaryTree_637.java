package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();         
            for (int i = 0; i < size; i ++) {
                TreeNode head = queue.poll();
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                level.add(head.val);
            }
            // 这里也可以直接定义为double，那后面sum就不需要转型成double可以直接res.add(sum/size)
            // 这里不可以定义成int sum = 0，因为如果level里面的整数如果很大，加起来有可能超过Integer的范围(32位)，
            // 所以要用更大范围的基本数据类型double(64位)，long(64位)
            long sum = 0; 
            for (Integer i : level) {
                sum += i;
            }
            res.add((double)sum / size);
            // 或者 res.add(1.0 * sum / size); 因为double / integer 是 double
        }
        return res;
    }
}

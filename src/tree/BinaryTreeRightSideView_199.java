package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> cur = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode head = queue.poll();
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                cur.add(head);
            }
            res.add(cur.get(cur.size() - 1).val);
        }
        return res;
    }
}

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {

			TreeNode head = stack.pop();
			if (head.right != null) {
				stack.push(head.right);
			}
			if (head.left != null) {
				stack.push(head.left);
			}
			res.add(head.val);

		}
		return res;
	}
}

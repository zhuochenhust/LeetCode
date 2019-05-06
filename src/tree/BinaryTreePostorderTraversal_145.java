package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// left ——> right ——> root
public class BinaryTreePostorderTraversal_145 {
	// Iteration
	public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return postorder;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postorder.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(postorder);
        return postorder;
    }
	
	// Recursion
	public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}

package tree;

public class SumOfLeftLeaves_404 {
	int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        helper(root.left);
        helper(root.right);
    }
}

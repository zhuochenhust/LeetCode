package tree;

public class LongestUnivaluePath_687 {
	int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
    
    // calcute the longest arrow extended from node(单边)
    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.val == node.left.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            arrowRight += right + 1;
        }
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}

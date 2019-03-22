package tree;

import org.junit.Test;

public class BinaryTreeMaximumPathSum_124 {
	int max = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, root.val + left + right);
        int current = root.val + Math.max(left, right);
        return current > 0 ? current : 0;
    }
    
    @Test
    public void testSolution() {
    	TreeNode root = new TreeNode(-10, new TreeNode(9, null, null), 
    					new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    	int res = maxPathSum(root);
    	System.out.println(res);
    }
}

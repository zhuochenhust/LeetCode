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
        // 负数加上root的值只会变小，所以不是无脑取left和right的最大值，要他们都为负数，哪怕取大的加上root也拖后腿了
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, root.val + left + right);
        // 每条边只能用一次，所以并不是返回max，如果返回max的话，那么按照例子结果就是13了
        return Math.max(left, right) + root.val;
    }
    
    @Test
    public void testSolution() {
    	TreeNode root = new TreeNode(0, new TreeNode(3, null, null), 
    					new TreeNode(2, new TreeNode(4, null, null), new TreeNode(4, null, null)));
    	int res = maxPathSum(root);
    	System.out.println(res);
    }
}

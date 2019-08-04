package recursion;

import org.junit.Test;

import tree.TreeNode;

public class RangeSumOfBST_938 {
	int ans = 0;
	public int rangeSumBST(TreeNode root, int L, int R) {  
        dfs(root, L, R);
        return ans;
    }
    
    public void dfs(TreeNode node, int L, int R) {
        if (node == null) return;
        if (node.val >= L && node.val <= R) {
            ans += node.val;
        }
        if (node.val > L) {
            dfs(node.left, L, R);
        }
        if (node.val < R) {
            dfs(node.right, L, R);
        }
    }
    
    @Test
    public void testSolution() {
    	TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, null, null), new TreeNode(7, null, null)),
    			new TreeNode(15, null, new TreeNode(18, null, null)));
    	int res = rangeSumBST(root, 7, 15);
    	System.out.println(res);
    }
}

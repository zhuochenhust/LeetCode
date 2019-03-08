package tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumDepthofBinaryTree_104Test {
	
	MaximumDepthofBinaryTree_104 mdbt = new MaximumDepthofBinaryTree_104();

	@Test
	public void testMaxDepth() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2, null, null), null);
		TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
		int res1 = mdbt.maxDepth(root1);
		int res2 = mdbt.maxDepth(root2);
		int ans1 = 2;
		int ans2 = 3;
		assertEquals(ans1, res1);
		assertEquals(ans2, res2);
	}

}

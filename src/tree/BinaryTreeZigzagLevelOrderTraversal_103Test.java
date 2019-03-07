package tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversal_103Test {
	
	BinaryTreeZigzagLevelOrderTraversal_103 btzlo = new BinaryTreeZigzagLevelOrderTraversal_103();
	TreeNode root = new TreeNode(3,new TreeNode(9,null,null), 
			new TreeNode(20, new TreeNode(15, null, null), 
			new TreeNode(7, null, null)));
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testZigzaglevelOrder() {
		List<List<Integer>> res = btzlo.zigzaglevelOrder(root);
		List<List<Integer>> ans = Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7));
		assertEquals(ans, res);
	}

}

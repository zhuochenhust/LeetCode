package Tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeLevelOrderTraversal_102Test {
	
	BinaryTreeLevelOrderTraversal_102 btot = new BinaryTreeLevelOrderTraversal_102();
	TreeNode root = new TreeNode(3,new TreeNode(9,null,null), 
					new TreeNode(20, new TreeNode(15, null, null), 
					new TreeNode(7, null, null)));

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLevelOrder() {
		List<List<Integer>> res = btot.levelOrder(root);
		List<List<Integer>> ans = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));
		assertEquals(ans, res);
	}

}

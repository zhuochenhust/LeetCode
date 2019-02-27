package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class binaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return helper(root, list);
        
    }
    public List<Integer> helper(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            List<Integer> left = helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            List<Integer> right = helper(root.right, list);
        }
        return list;
    }
    
    @Test
	public void solutionTest(){
    	binaryTreeInorderTraversal btit = new binaryTreeInorderTraversal();
    	TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    	List<Integer> res = btit.inorderTraversal(root);
    	for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
    }
}



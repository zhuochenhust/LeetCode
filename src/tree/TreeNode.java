package tree;

public class TreeNode {
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

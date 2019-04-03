package tree;

public class MergeTwoBinaryTrees_617 {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        TreeNode right = mergeTrees(t1.right, t2.right);
        TreeNode left = mergeTrees(t1.left, t2.left);
        root.left = left;
        root.right = right;
        return root;
    }
}

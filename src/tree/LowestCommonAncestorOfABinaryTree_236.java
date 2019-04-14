package tree;

public class LowestCommonAncestorOfABinaryTree_236 {
	//如果找到 p 或者 q 那么就可以返回没有必要接着递归，因为共同祖先只可能是该节点或该节点祖先
	//如果 root 为空了，说明这条路径上不可能有 p 或 q 节点，返回空
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 往左分支寻找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 往右分支寻找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { //说明 p 和 q 是分布在 root 两侧，返回即可
            return root;
        }
        if (left != null) { //说明在 left 分支上找到 p 或 q 节点，返回即可
            return left;
        }
        if (right != null) { //说明在 right 分支上找到 p 或 q 节点，返回即可
            return right;
        }
        return null;
    }
}

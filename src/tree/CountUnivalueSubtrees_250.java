package tree;

public class CountUnivalueSubtrees_250 {
	int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
    
    /**
     * 1. 一个node左右都为空，则必为univalue subtree
     * 2. 树的所有的node的children是univalue subtree，
     *    且node和他的children的value是一样的
     */
    public boolean is_uni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count ++;
            return true;
        }
        boolean is_unival = true;
        // 检查是否所有node的children是univalue subtree，是否他们val相同
        // 对children递归调用is_uni
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }
        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }
        if (!is_unival) return false;
        count ++;
        return true;
    }
}

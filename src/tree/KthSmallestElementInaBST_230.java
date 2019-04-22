package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInaBST_230 {
	// 这题关键是想到用inorder来做
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        inorder(root, res);
        return res.get(k - 1).val;
    }
    
    public void inorder(TreeNode root, List<TreeNode> res) {     
        if (root == null) return;
        inorder(root.left, res);
        res.add(root);
        inorder(root.right, res);
    }
}

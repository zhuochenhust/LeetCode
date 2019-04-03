package tree;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
	TreeNode curNode;
    Stack<TreeNode> stack = new Stack<>();;
    public BinarySearchTreeIterator_173(TreeNode root) {
        curNode = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while(curNode != null) { //整个过程类似于DFS，所以用stack
            stack.push(curNode);
            curNode = curNode.left;
        }
        TreeNode node = stack.pop();
        curNode = node.right;
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (curNode != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BinarySearchTreeIterator_173(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

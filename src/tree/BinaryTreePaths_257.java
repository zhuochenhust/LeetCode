package tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTreePaths_257 {
	// 方法1: 用 + 做字符串拼接
	public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, "");
        return res;
    }
    
    public void helper(TreeNode root, List<String> paths, String path) {
        if (root == null) return;
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null) { // reach leaf
            paths.add(path); // update path
            return; // 走到头了path加入到paths里面去任务就完成了，返回。不写返回也可以，因为往下执行的时候，root.left == null 自然也会返回。
        }
        path += "->";
        helper(root.left, paths, path); // 往左走后面的路径都加到path中，走到头了然后放到paths里面去
        helper(root.right, paths, path); // 往右走后面的路径都加到path中，走到头了然后放到paths里面去
    }
	
    // 方法2: 用 StringBuilder 做字符串拼接, 推荐！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	public List<String> binaryTreePaths_2(TreeNode root) { 
        List<String> res = new ArrayList<>();
        helper(root, res, new StringBuilder());
        return res;
    }
    
    public void helper(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null) return;
        // 记录append新节点之前sb的长度方便后面回溯
        // 为何不用sb.deleteCharAt(sb.length() - 1)回溯？因为有->
        int len = sb.length(); 
        sb.append(root.val);
        if(root.left == null && root.right == null){ // reach leaf
            res.add(sb.toString());
        }
        sb.append("->");
        helper(root.left, res, sb);
        helper(root.right, res, sb);
        sb.setLength(len);
    }
    
    // 若想不写回溯过程，就好像用字符串和“+”拼接的方法一样的话，就按下面这么写helper()
    public void helper_sb_no_backtracking(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null) return;
        sb = new StringBuilder(sb).append(root.val);
        if(root.left == null && root.right == null){ // reach leaf
            res.add(sb.toString());
        }
        sb.append("->");
        helper_sb_no_backtracking(root.left, res, sb);
        helper_sb_no_backtracking(root.right, res, sb);
    }
    
    @Test
    public void testSolution() {
    	TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)), 
    					new TreeNode(3, null, null));
    	List<String> res1 = binaryTreePaths_1(root1);
    	System.out.println("method1's result is: ");
    	for (String s : res1) {
    		System.out.println(s);
    	}
    	TreeNode root2 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    	List<String> res2 = binaryTreePaths_2(root2);
    	System.out.println("method2's result is: ");
    	for (String s : res2) {
    		System.out.println(s);
    	}
    }
}

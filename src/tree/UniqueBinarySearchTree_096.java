package tree;

import org.junit.Test;

/**
 * Problem: Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Problem link: https://leetcode.com/problems/unique-binary-search-trees/
 * */

public class UniqueBinarySearchTree_096 {
	/**
	 * 动态规划：
	 * 1. 定义状态变量
	 * 2. 状态变量初始化
	 * 3. 转移方程
	 * 
	 * */
	public int numTrees(int n) {
		if (n < 0) return 0;
		/** 
		 * 1. 定义状态变量, 因为有G[0], 所以数组应该有n+1容量
		 *    G[i] 代表 i 个节点的时候的状态数
		 * */
		int[] G = new int[n + 1]; 
		/** 
		 * 2. 状态变量初始化
		 * */
		G[0] = 1; // empty tree
		G[1] = 1; // root only
		/** 
		 * 3. 转移方程
		 *    0, 1，2，3,...，j - 1 || j(pick as root) || j+1, j+2,...,k
		 *          G[j]                                    G[k-j-1]
		 *    j为root的时候，状态数 = 左 * 右
		 *    总状态数 = 0～n-1求和 [j] * [i-j-1]
		 * */
		for (int i = 2; i <= n; i ++) { //i就是上面的k，总节点数
			for (int j = 0; j < i; j ++) { //以j为root的左子树BST，左子树最少0个节点，最多i-1个节点
				G[i] += G[j] * G[i - j - 1];
			}
		}
		//返回总节点数i=n的值
		return G[n];
	}
	
	@Test
	public void solutionTest(){
		UniqueBinarySearchTree_096 ubst = new UniqueBinarySearchTree_096();
		int res = ubst.numTrees(3);
		System.out.println(res);
	}
}

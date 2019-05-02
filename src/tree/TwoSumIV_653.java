package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 这道two sum题的输入变成了一个BST，这题的基本思路首先肯定是遍历tree，然后需要一个容器比如list装当前current sum
 *
 * HashSet 作为一种Set容器,包含有boolean add(Object o)，void clear()，boolean contains(object o)，
 * boolean isEmtpy()，boolean remove(Object o),int size()之类的方法
 * 但是Hashset容器的方法其实都可以在List容器找到替换的方法.例如ArrayList 容器也有 contains(Object o), remove(Object o) 的方法。
 * 也就是说, 在coding中, HashSet的方法完全可以用ArrayList来取代. 
 * 但是HashSet自然有它的优点. 这个优点就是访问数据的性能.
 * 就比如同于同1个方法boolean contains(Object o),  无论是ArrayList 还是 LinkList, 都是需要遍历List的, 值到找到该元素为止.
 * 而HashSet是基于Hashcode() 找到该元素的位置, 大大减少(非避免)遍历的行为.
 * */
public class TwoSumIV_653 {
	public boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return helper(root, k, set);
	}
	
	public boolean helper(TreeNode root, int k, Set<Integer> set) {
		if (root == null) return false;
		if (set.contains(k - root.val)) return true;
		set.add(root.val);
		return helper(root.left, k, set) || helper(root.right, k, set);
	}
}

package array;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/** 
 * Problem: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 			You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Problem link: https://leetcode.com/problems/two-sum/
 **/

public class TwoSum_001 {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) return null;
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i ++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < n; i ++) {
			int newTarget = target - nums[i];
			if (map.containsKey(newTarget) && i != map.get(newTarget)) {
				return new int[]{i, map.get(newTarget)};
			}
		}
		return null;
	}
	
	@Test
	public void solutionTest() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		int[] ans = {0, 1};
		assertEquals(ans[0], res[0]);
		assertEquals(ans[1], res[1]);
	}
}

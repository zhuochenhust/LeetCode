package array;
/**
 * 1. 如果位置i的左边最大的高度小于右边最大高度，那么该位置所能存储的水量就固定了（leftmax - height[i]）
 * 2. 如果位置i的右边最大的高度小于左边最大高度，那么该位置所能存储的水量就固定了（rightmax - height[i]）
 * */
public class TrappingRainWater_042 {
	public int trap(int[] height) {
		if (height == null || height.length < 3) return 0;
		int i = 0, j = height.length - 1;
		int leftmax = height[i], rightmax = height[j];
		int max = 0;
		while (i < j) {
			leftmax = Math.max(height[i], leftmax);
			rightmax = Math.max(height[j], rightmax);
			if (leftmax < rightmax) {
				max += leftmax - height[i];
				i ++;
			} else {
				max += rightmax - height[j];
				j --;
			}
		}
		return max;
	}
}

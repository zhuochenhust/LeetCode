package classicQuestion;

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

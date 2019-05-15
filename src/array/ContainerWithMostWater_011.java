package array;

public class ContainerWithMostWater_011 {
	public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxVolume = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxVolume = Math.max(maxVolume, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i ++;
            } else {
                j --;
            }
        }
        return maxVolume;
    }
}

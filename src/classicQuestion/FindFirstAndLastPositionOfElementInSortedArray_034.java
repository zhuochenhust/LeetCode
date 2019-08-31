package classicQuestion;

public class FindFirstAndLastPositionOfElementInSortedArray_034 {
	public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                break;
            }
        }
        int mid = (start + end) / 2;
        if (nums[mid] != target) return new int[]{-1, -1};
        int i = mid, j = mid;
        while (i >= 0 || j < nums.length) {
            boolean isMatch = false;
            if (i > 0 && nums[i] == nums[i - 1]) {
                i --;
                isMatch = true;
            }
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j ++;
                isMatch = true;
            }
            if (!isMatch) {
                break;
            }
        }
        return new int[]{i, j};
    }
}

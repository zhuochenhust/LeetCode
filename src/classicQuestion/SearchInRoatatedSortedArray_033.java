package classicQuestion;

public class SearchInRoatatedSortedArray_033 {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[low]) {  //mid在左边
                if (nums[mid] >= target && target >= nums[low]) { //说明target在左边
                    high = mid - 1;
                } else { //说明target在右边
                    low = mid + 1;
                }
            } else { //mid在右边
                if (nums[mid] <= target && target <= nums[high]) { //说明target在右边
                    low = mid + 1;
                } else { //说明target在左边
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

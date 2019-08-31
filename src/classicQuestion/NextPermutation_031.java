package classicQuestion;

public class NextPermutation_031 {
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) break;
            i--;
        }
        int j = nums.length - 1;
        if (i > 0) {
            while (j > i) {
                if (nums[j] > nums[i - 1]) break;
                j --;
            }
            swap(nums, i - 1, j);
        }     
        reverse(nums, i);
    }
    
    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i ++;
            j --;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

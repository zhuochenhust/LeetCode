package array;
/**
 * 非常巧妙的方法：
 * 1. 初始化candidate为数组第一个元素，此时count记为1
 * 2. 往后遍历数组，如果当前元素等于candidate，count++， 不等于则count--
 * 3. 一旦count为0，则下一个元素为candidate，count = 1
 * */
public class MajorityElement_169 {
	public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            if (count == 0) {
                candidate = nums[i];
                count ++;
            } else if (candidate == nums[i]) {
                count ++;
            } else {
                count --;
            }
        }
        return candidate;
    }
}

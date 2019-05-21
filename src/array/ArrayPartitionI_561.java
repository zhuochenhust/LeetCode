package array;

import java.util.Arrays;

public class ArrayPartitionI_561 {
	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Time complexity : O(nlog(n)), Sorting takes O(nlog(n)) time. We iterate over the array only once. 
 * Space complexity : O(1). Constant extra space is used.
 * */
 
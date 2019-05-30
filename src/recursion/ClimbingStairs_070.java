package recursion;

public class ClimbingStairs_070 {
	public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return helper(n, arr);
    }
    public int helper(int n, int[] arr) {
        if (n <= 2) return n;
        if (arr[n] != 0) {
            return arr[n];
        } else {
            arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
            return arr[n];
        }
    }
}

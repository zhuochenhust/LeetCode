package backtracking;

import org.junit.Test;

/**
 * When n == 0, return 1. I got this answer from the test case
 * When n == 1, _ can put 10 digit in the only position. [0, ... , 9]. Answer is 10
 * When n == 2, _ _ first digit has 9 choices [1, ..., 9], second one has 9 choices excluding the already chosen one. So totally 9 * 9 = 81. answer should be 10 + 81 = 91
 * When n == 3, _ _ _ total choice is 9 * 9 * 8 = 684. answer is 10 + 81 + 648 = 739
 * When n == 4, _ _ _ _ total choice is 9 * 9 * 8 * 7
 * ...
 * When n == 10, _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
 * When n == 11, _ _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 * 0 = 0
 * */
public class CountNumbersWithUniqueDigits_357 {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int sum = 10, q = 9;
        for (int i = 1; i < n; i ++) {
            q *= 10 - i;
            sum += q;
        }
        return sum;
    }
	@Test
	public void testSolution() {
		int n = 3;
		System.out.println(countNumbersWithUniqueDigits(n));
	}
}

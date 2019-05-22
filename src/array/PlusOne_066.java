package array;

public class PlusOne_066 {
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] += 1;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}

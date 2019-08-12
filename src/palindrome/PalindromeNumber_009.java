package palindrome;

public class PalindromeNumber_009 {
	public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int x_reversed = 0, x_original = x;
        while (x != 0) {
            x_reversed = 10 * x_reversed + x % 10;
            x = x / 10;
        }
        return x_reversed == x_original;
    }
}

package classicQuestion;

public class ReverseInteger_007 {
	public int reverse(int x) {
        long out = 0; // result might overflow
        while (x != 0) {
            out = out * 10 + x % 10; // append last digit of x
            x = x / 10; // remove last digit
        }
        if (out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) return 0;
        return (int)out;
    }
}

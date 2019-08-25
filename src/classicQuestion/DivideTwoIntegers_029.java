package classicQuestion;

public class DivideTwoIntegers_029 {
	public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean positive = (dividend > 0 && divisor > 0) ||
                             (dividend < 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){ // a < b 直接就是0了
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return positive? result: -result;
    }

}

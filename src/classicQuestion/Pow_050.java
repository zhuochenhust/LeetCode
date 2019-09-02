package classicQuestion;

public class Pow_050 {
	public double myPow(double x, int n) {
        return (n >= 0) ? power(x, n) : 1.0 / power(x, -n);
    }
    
    public double power(double x, int n) {
        if (n == 0) return 1; // 递归终止条件
        double tmp = power(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }

}

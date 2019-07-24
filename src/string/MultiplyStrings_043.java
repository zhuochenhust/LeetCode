package string;

import org.junit.Test;

public class MultiplyStrings_043 {
	public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i --) {
            for (int j = len2 - 1; j >= 0; j --) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int posLow = i + j + 1;
                int posHigh = i + j;
                mul += result[posLow];
                result[posLow] = mul % 10;
                result[posHigh] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() == 0 && num == 0) { //跳过开头的0
                continue;
            } else {
                sb.append(num);
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString(); // 处理每一位都是0的特殊情况，返回0
    }

	
	@Test
	public void testSolution() {
		String num1 = "2", num2 = "3";
		System.out.println(multiply(num1, num2));
	}
}

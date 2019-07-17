package string;

public class ZigZagConversion_006 {
	public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i ++) {
            sb[i] = new StringBuilder();
        }
        int i = 0, len = s.length();
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j ++) {
                sb[j].append(s.charAt(i ++));
            }
            for (int j = numRows - 2; j > 0 && i < len; j --) {
                sb[j].append(s.charAt(i ++));
            }
        }
        for (int k = 1; k < numRows; k ++) {
            sb[0].append(sb[k]);
        }
        return sb[0].toString();
    }
}

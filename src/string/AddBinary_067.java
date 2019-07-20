package string;

public class AddBinary_067 {
	public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean inc = false;
        while (i >= 0 && j >= 0) {
            int a_int = a.charAt(i) - '0';
            int b_int = b.charAt(j) - '0';
            int sum = a_int + b_int + (inc ? 1 : 0);
            sb.append(sum % 2); // sum 最大为3，sum % 2 = 1
            inc = (sum >= 2);
            i --;
            j --;
        }
        while (i >= 0) {
            int a_int = a.charAt(i) - '0';
            int sum = a_int + (inc ? 1 : 0);
            sb.append(sum % 2);
            inc = (sum >= 2);
            i --;
        }
        while (j >= 0) {
            int b_int = b.charAt(j) - '0';
            int sum = b_int + (inc ? 1 : 0);
            sb.append(sum % 2);
            inc = (sum >= 2);
            j --;
        }
        if (inc) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

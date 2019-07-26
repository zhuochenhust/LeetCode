package string;

public class ReverseString_344 {
	public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i ++;
            j --;
        }
    }
    
    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
	
	public void reverseString_2(char[] s) {
        if (s == null || s.length == 0) return;
        // int i = 0, j = s.length- 1;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i --) {
            sb.append(s[i]);
        }
        char[] c = sb.toString().toCharArray();
        for (int i = 0; i < s.length; i ++) {
            s[i] = c[i];
        }
        return;
    }
}

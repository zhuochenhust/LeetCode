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
}

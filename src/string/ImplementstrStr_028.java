package string;

public class ImplementstrStr_028 {
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int i = 0, hlen = haystack.length(), nlen = needle.length();
        while (i < hlen) {
            if (i + nlen <= hlen && haystack.substring(i, i + nlen).equals(needle)) {
                return i;
            }
            i ++;
        }
        return -1;
    }
}

package string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReverseWordsInAString_151 {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        s = s.trim();
        List<String> list = new ArrayList<>();
        int i = 0;
        int wordLen = 0;
        while (i < s.length()) {
            while (s.charAt(i) == 32) {
            	// 判断一个char是否为空格，两种方式，第一种：看是否等于32；第二种：Character.isSpace(s.charAt(i - 1))
                if (i > 0 && s.charAt(i - 1) != 32) {
                    list.add(s.substring(i - wordLen, i));
                }
                wordLen = 0;
                i ++;
                continue;
            }
            i ++;
            wordLen ++;
        }
        list.add(s.substring(i - wordLen, i));
        StringBuilder sb = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j --) {
            sb.append(list.get(j));
            if (j != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
	
	@Test
	public void testSolution() {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}

package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SubstringWithConcatenationOfAllWords_030 {
	public List<Integer> findSubstring(String s, String[] words) {
        // 创建呈放结果的list
        List<Integer> res = new ArrayList<>();
        
        // 特殊情况判断
        if (words == null || words.length == 0) return res;
        int lenWords = words.length * words[0].length();
        if (s == null || s.length() < lenWords) return res;
        
        
        
        // 遍历s中每一个长度为lenWords的子串
        int i = 0;
        while (i <= s.length() - lenWords) {
        	String sub = s.substring(i, i + lenWords);
            if (check(sub, words)) {
                res.add(i ++);
            } else {
                i ++;
            }
        }
        
        return res;
        
    }
    
    // 写一个方法来判断一个长度为lenWords的字符串是否是words里的字符串串联形成的
    public boolean check(String s, String[] words) {
        // 创建words中每一个word的HashMap
        Map<String, Integer> wordDict = new HashMap<>();
        for (String word : words) {
            if (wordDict.containsKey(word)) {
                wordDict.put(word, wordDict.get(word) + 1);
            } else {
                wordDict.put(word, 1);
            }
        }
        
        int len = words[0].length();
        
        // 创建一个临时map用来记录s的长度为len的子串
        Map<String, Integer> tmpDict = new HashMap<>();
        
        for (int i = 0; i <= s.length() - len; i += len) {
            String str = s.substring(i, i + len);
            if (!wordDict.containsKey(str)) {
                return false;
            } else {
                if (tmpDict.containsKey(str)) {
                    tmpDict.put(str, tmpDict.get(str) + 1);
                    if (tmpDict.get(str) > wordDict.get(str)) {
                        return false;
                    }
                } else {
                    tmpDict.put(str, 1);
                }
            }
        }
        return true;
    }
    
    @Test
    public void testSolution() {
    	String s = "barfoothefoobarman";
    	String[] words = {"foo", "bar"};
    	System.out.println(findSubstring(s, words));
    }
}

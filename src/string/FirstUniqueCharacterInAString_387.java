package string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString_387 {
	public int firstUniqChar_1(String s) {
        if(s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
	
	// 更好的方法，用数组，非常常见的解法。
	public int firstUniqChar_2(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a'] ++;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            if (count[cur - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

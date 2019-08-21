package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_013 {
	public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 这里一定注意别写成String了，因为后面charAt是char
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                ans = ans + map.get(s.charAt(i));
            } else {
                ans = ans - map.get(s.charAt(i));
            }
        }
        ans = ans + map.get(s.charAt(s.length() - 1));
        return ans;
    }
}

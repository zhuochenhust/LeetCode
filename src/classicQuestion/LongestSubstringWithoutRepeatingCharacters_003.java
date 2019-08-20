package classicQuestion;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_003 {
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else { 
                //以s.charAt(i)开头的不重复substring已经最长了，只需要从set中把s.charAt(i)移除，剩下的就是以s.charAt(i+1)开头的不重复substring
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}

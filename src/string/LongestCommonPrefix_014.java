package string;

public class LongestCommonPrefix_014 {
	// 方法1： 最初的思路，先从字符串数组中第一个字符串拿开头的子串作prefix，然后一个个地看数组后面的字符串是不是都是以这个prefix开头的。
	// 关键问题在于，这个prefix的长度怎么选取。 我的第一种算法就是以prefix长度为1开始，到2到3...直到某一个长度的prefix不是共同prefix为止。
	public String longestCommonPrefix_1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minStrLen = strs[0].length();
        for (int i = 1; i < strs.length; i ++) {
            if (strs[i].length() < minStrLen) {
                minStrLen = strs[i].length();
            }
        }
        int maxPrefixLen = 0;
        StringBuilder sb = new StringBuilder();
        
        while(maxPrefixLen < minStrLen) {
            char c = strs[0].charAt(maxPrefixLen);
            for (int i = 1; i < strs.length; i ++) {
                if (strs[i].charAt(maxPrefixLen) == c) {
                    continue;
                } else {
                    return sb.toString();   
                }
            }
            sb.append(c);
            maxPrefixLen ++;
        }
        return sb.toString();
     }
	
	// 方法2： 改进方法： 选取prefix的初始长度不从1开始，用二分法。
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minStrLen = strs[0].length();
        for (int i = 1; i < strs.length; i ++) {
            if (strs[i].length() < minStrLen) {
                minStrLen = strs[i].length();
            }
        }
        int low = 1, high = minStrLen;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // return strs[0].substring(0, low + (high - low) / 2); 只有确认low小于high的时候，才可以这么写，当high此时可能已经小于low的时候，这么写会报异常
         return strs[0].substring(0, (low + high) / 2);
     }
    
    public boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i ++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}

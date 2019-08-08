package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString_761 {
	class Solution {
	    public String makeLargestSpecial(String s) {
	        if (s == null || s.length() == 0) return s;
	        int count = 0, anchor = 0;
	        List<String> list = new ArrayList<>();
	        for (int i = 0; i < s.length(); i ++) {
	            count += s.charAt(i) == '1' ? 1 : -1;
	            if (count == 0) {
	                // 字符串的起始位置一定是"1", 结束位置一定是"0"，所以只需要递归中间部分
	                list.add("1" + makeLargestSpecial(s.substring(anchor + 1, i)) + "0");
	                anchor = i + 1;
	            }
	        }
	        Collections.sort(list, Collections.reverseOrder());
	        StringBuilder sb = new StringBuilder();
	        for (String str : list) {
	            sb.append(str);
	        }
	        return sb.toString();
	    }
	}
}

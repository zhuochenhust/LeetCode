package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString_761 {
	class Solution {
	    /*
	    遇到左括号加1，遇到右括号-1，这样得到0的时候，就是一个合法的子字符串了。
	    我们用变量i来统计这个合法子字符串的起始位置，用list来保存这些合法的子字符串。
	    好了，我们开始遍历字符串S，遇到1，count+1，否则自减1。当count为0时，
	    我们将这个字串加入list，注意前面说过，我们需要给这个字串自身也排序，
	    所以我们要对自身调用递归函数，我们不用对整个子串调用递归，
	    因为字串的起始位置和结束位置是确定的，一定是1和0，我们只需对中间的调用递归即可。
	    当我们将所有排序后的合法字串存入list中后，我们对list进行排序，将字母顺序大的放前面，
	    最后将其连为一个字符串即可
	    */
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

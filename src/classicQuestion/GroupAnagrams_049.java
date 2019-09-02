package classicQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_049 {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            // char array --> String:
            // 1. String key = Arrays.toString(cur);
            // 2. String key = String.valueOf(cur);
            String key = Arrays.toString(cur);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        // return new ArrayList<List<String>>(map.values()); 直接这样返回也是可以的
        for (List<String> cur : map.values()) {
            res.add(cur);
        }
        return res;
    }

}

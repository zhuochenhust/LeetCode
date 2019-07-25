package string;

import java.util.LinkedList;
import java.util.List;

public class RansomNote_383 {
	public boolean canConstruct_1(String ransomNote, String magazine) {
		if (ransomNote == null || ransomNote.length() == 0)
			return true;
		if (magazine == null || magazine.length() == 0)
			return false;
		List<Character> list = new LinkedList<>();
		for (int i = 0; i < magazine.length(); i++) {
			list.add(magazine.charAt(i));
		}
		for (int j = 0; j < ransomNote.length(); j++) {
			if (list.contains(ransomNote.charAt(j))) {
				// 用到list.remove(Object o), 所以一定要是封装类Character，不能是char
				// new Character(char c)已经被淘汰了，现在要用Character.valueOf(char c)
				list.remove(Character.valueOf(ransomNote.charAt(j)));
			} else {
				return false;
			}
		}
		return true;
	}

	// 这是更好的方法，我们要记录每一个magazine中的字符和它对应的次数，可以用hashmap也可以用数组，但数组是最快的
	public boolean canConstruct_2(String ransomNote, String magazine) {
		if (ransomNote == null || magazine == null)
			return false;
		if (ransomNote.length() > magazine.length())
			return false;
		if (ransomNote.length() == 0)
			return true;
		/*
		 * 时间：O(2n) 空间：O(n)
		 * 
		 * 以magazine中的每一个英文字母的ascii码为下标 c-'a'，值为该字母出现的次数，作为数组。
		 * 循环ransomNote，检查ransomNote中的每个字母是否能耗尽上述数组中的次数。如果耗尽到-1，则表示false
		 */

		int[] counts = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			counts[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (counts[ransomNote.charAt(i) - 'a'] == 0)
				return false;
			counts[ransomNote.charAt(i) - 'a']--;
		}
		return true;
	}
}

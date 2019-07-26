package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return "";
        List<Integer> vPos = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            if (isVowels(cur)) vPos.add(i);
        }
        
        int size = vPos.size();
        char[] chars = s.toCharArray();
        
        int i = 0, j = size - 1;
        
        while (i <= j) {
            swap(chars, vPos.get(i), vPos.get(j));
            i ++;
            j --;
        }
        
        // return String.valueOf(chars);
        return new String(chars);
    }
    
    public boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
         || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }
    
    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }   
}

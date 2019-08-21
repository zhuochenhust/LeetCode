package classicQuestion;

public class StringToInteger_008 {
public int myAtoi(String str) {
        
        // 1. remove whitespaces
        str = str.trim(); // 不要忘记str=直接写str.trim();
        
        // 2. null or empty string
        // 非空判断要在去除空格之后进行，因为若str为” “,去除空格前不为空长度也不为0，但是trim后就变成””了。空字符串trim还是空字符串，所以先trim再判断
        if (str == null || str.length() == 0) return 0;
        
        // 3. +/- sign
        boolean positive = true;
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            positive = false;
            i++;
        }
        
        // 4. calculate real value
        long tmp = 0;//
        for ( ; i < str.length(); i++) {
            int digit = str.charAt(i) - '0'; // 常用的由字符找到对应数字的方法：字符-‘0'
            
            if (digit < 0 || digit > 9) break; //若不是数字，直接跳出循环返回tmp = 0
            
            // 5. handle min & max
            if (positive) {
                tmp = 10 * tmp + digit;
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                tmp = 10 * tmp - digit;
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        
        int ans = (int)tmp;
        return ans;
    }

}

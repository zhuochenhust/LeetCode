class IntegerToRoman_012 {
    public final int[] intDict = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public final String[] romanDict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        if (num <= 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 13) {
            // 1. 寻找最高位置的罗马字母
            if (intDict[i] <= num) {
                // 2. 将最高位Roman放入sb
                sb.append(romanDict[i]);
                // 3. 更新 num
                num -= intDict[i];
            } else {
                i ++;
            }
        }
        return sb.toString();
    }
}

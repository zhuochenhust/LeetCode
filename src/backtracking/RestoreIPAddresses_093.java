class RestoreIPAddresses_093 {
    // 1.一共有4段，每一段之间用点号'.'隔开.
    // 2.每一段的值小于等于255.
    // 3.每一段不能以0开头（除了只有0本身的情况）.
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) return res;
        StringBuilder sb = new StringBuilder();
        helper(s, res, sb, 0, 0);
        return res;
    }
    
    // 我们每次尝试从给定的字符串s种拿出一个字符，或者两个字符，或者三个字符作为一段，然后从剩下的字符种拿出一个，或两个，或三个作为一段
    // count代表已经去到的段数，index表示未用到的字符开始的索引
    public void helper(String s, List<String> res, StringBuilder sb, int count, int index) {
        if (count > 4 || index > s.length()) return;
        if (index == s.length()) { // 字符都用完了
            if (count == 4) { // 已经去到了4段
                res.add(sb.toString());
                return;
            }
            return;
        }
        // 每次调用递归都说明完成了一段ip进入下一段，需要加.
        // 但是第一次调用的时候不需要所以：加一个条件count > 0。因为只有最开始等于0，剩下的都大于0
        if (count > 0) sb.append('.');
        
        // 1 digit
        sb.append(s.charAt(index));
        helper(s, res, sb, count + 1, index + 1);
        //sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        
        // 2 digits
        if (index < s.length() - 1 && s.charAt(index) != '0') {
            sb.append(s.charAt(index)).append(s.charAt(index + 1));
            helper(s, res, sb, count + 1, index + 2);
            sb.delete(sb.length() - 2, sb.length());
        }
        
        // 3 digits
        if (index < s.length() - 2 && s.charAt(index) != '0' && Integer.valueOf(s.substring(index, index + 3)) <= 255) {
            sb.append(s.charAt(index)).append(s.charAt(index + 1)).append(s.charAt(index + 2));
            helper(s, res, sb, count + 1, index + 3);
            sb.delete(sb.length() - 3, sb.length());
        }
        
        // 每次递归调用结束都要把最开始加的.去掉
        // 但是第一次调用的时候不需要所以：加一个条件count > 0。因为只有最开始等于0，剩下的都大于0
        if (count > 0) sb.deleteCharAt(sb.length() - 1);
    }
}

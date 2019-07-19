class CountAndSay_038 {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        for (int i = 1; i < n; i ++) {
            res = countAndSayArray(res);
        }
        return res;
    }
    
    // method用来执行count and say的操作
    public String countAndSayArray(String cas) {
        int count = 1;
        int i = 0;
        int len = cas.length();
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            // 这里注意任何时候先判断是否valid（i+ count < len），再判断是否相等
            while (i + count < len && cas.charAt(i) == cas.charAt(i + count)) {
                count ++;
            }
            sb.append(count).append(cas.charAt(i));
            i += count;
            count = 1;
        }
        return sb.toString();
    }
}

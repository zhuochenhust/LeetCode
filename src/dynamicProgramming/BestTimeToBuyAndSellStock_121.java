package dynamicProgramming;

public class BestTimeToBuyAndSellStock_121 {
	// DP方法:
	public int maxProfit_1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] dp = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            if (prices[i] < minPrice) minPrice = prices[i];
        }
        return dp[n - 1];
    }
	
	// 普通方法:
	public int maxProfit_2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minPrice)  // 时时更新当前最低价
                minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit) // 实时更新当前最高利润
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}

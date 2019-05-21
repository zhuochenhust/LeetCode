package array;

public class BestTimeToBuyAndSellStock_121 {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minPrice) 
                minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit) 
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}

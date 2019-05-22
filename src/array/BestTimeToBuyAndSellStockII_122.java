package array;

public class BestTimeToBuyAndSellStockII_122 {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int i = 0;
        int peak = prices[0], valley = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1) { // 这里不要忘记-1，不然会无限循环
            // 这里注意两个while循环的顺序不能反，永远是先找低的点入，再找高的点出。
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i ++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i ++;
            }
            peak = prices[i];            
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}

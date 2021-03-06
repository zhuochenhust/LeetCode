package dynamicProgramming;

public class BestTimeToBuyAndSellStock_III_123 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices == null || n == 0) {
            return 0;
        }

        int[] local = new int[3];
        int[] global = new int[3];
        
        for(int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            
            for(int j = 2; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }
}

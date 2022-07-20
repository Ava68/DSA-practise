https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        
        int result = 0;
        int smallest = Integer.MAX_VALUE;
        
        for(int i =0; i<prices.length; i++)
        {           
            result = Math.max(result,prices[i]- smallest);
            smallest = Math.min(smallest,prices[i]);
            
        }
        
        return result;
    }
}

class Solution {
    public int buy(int i, int j, int[] prices, int[][] dp){
        if(i > 1 || j >= prices.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i==0){
            int b = buy(1, j+1, prices, dp) - prices[j];
            int l = buy(0, j+1, prices, dp);
            return dp[i][j] = Math.max(b, l);
        }
        else{
            int s = buy(0, j+1, prices, dp) + prices[j];
            int l = buy(1, j+1, prices, dp);
            return dp[i][j] = Math.max(s, l);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1); 
        Arrays.fill(dp[1], -1);
        int ans = Math.max(buy(0, 0, prices, dp), buy(1, 0, prices,dp) - prices[0]);
        return ans; 
    }
}
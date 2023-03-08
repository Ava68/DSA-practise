https://leetcode.com/problems/min-cost-climbing-stairs/description/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
       return  helper(cost.length,cost,dp);
    }
    public int helper(int n,int [] cost,int dp[]){

        if(n == 0 || n == 1)
            return 0;

        if(dp[n] != -1)
            return dp[n];
        int costOneStep = cost[n-1] + helper(n-1,cost,dp);
        int costTwoStep = cost[n-2] + helper(n-2,cost,dp);

        return dp[n] = Math.min(costOneStep,costTwoStep);
    }
}

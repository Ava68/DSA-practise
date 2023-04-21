https://leetcode.com/problems/profitable-schemes/description/

Memoization

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][] = new int[102][102][102];
        int mod = 1000000007;
        for(int i =0; i<102; i++){
            for(int j =0; j<102; j++){
                for(int k =0; k<102; k++)
                    dp[i][j][k] = -1;
            }
        }
        return helper(0,0,0,n,minProfit,group,profit,dp,mod);
    }

    public int helper(int k,int i, int j, int n, int minProfit,int [] group,int [] profit,int dp[][][],int mod) {

        if(k == profit.length){
            if(j >= minProfit && n >= i)
                return 1;
            else
                return 0;
        }
        else if(n<i) 
            return 0;
      
        if(dp[k][i][j] != -1)
            return dp[k][i][j];

        int take = 0;
        int notTake = 0;

        take = helper(k+1,i,j,n,minProfit,group,profit,dp,mod);
        notTake = helper( k+1,i+group[k], Math.min(j+profit[k],minProfit), n, minProfit, group,profit,dp,mod );

        return dp[k][i][j] = (take + notTake) %mod;
    }
}

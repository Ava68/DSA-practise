https://leetcode.com/problems/climbing-stairs/

// memoization
class Solution {
     public int climbStairs(int n) {
         int dp [] = new int[n+1];
         Arrays.fill(dp,-1);
        
         return recfun(n,dp);
     }
     public int  recfun(int n,int dp[])
     {
         if(n <=1)
             return 1;
        
         if(dp[n] != -1)
             return dp[n];
        
        return dp[n] = recfun(n-1,dp) + recfun(n-2,dp);
     }
    
    // tabulation
    public int  climbStairs(int n)
    {
        int dp [] = new int[n+1];
       
       dp[0] = 1;
       dp[1] = 1;
        
      for(int i =2; i<=n; i++)
      {
           dp[i] = dp[i-1] + dp[n-2];
      }
    
        return dp[n];
      
    }
}



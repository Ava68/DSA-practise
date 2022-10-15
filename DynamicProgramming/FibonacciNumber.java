https://leetcode.com/problems/fibonacci-number/submissions/
// Memoization
class Solution {
    public int fib(int n) {
        
    int dp[] = new int[31];
    
    for(int i =0; i<31; i++)
    {
        dp[i] = -1;
    }
    
       return getfib(dp,n);
}
    
    public int getfib(int dp[], int n)
    {
         if(n == 0 || n == 1)
            return dp[n] = n;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = getfib(dp,n-1) + getfib(dp,n-2);
    }
    
// Tablulation 
public int fib(int n) {
        
    int dp[] = new int[31];
    
    dp[0] = 0;
    dp[1] = 1;
    
    for(int i =2; i<=n; i++)
    {
        dp[i] = dp[i-1] + dp[i-2];
    }
    
    return dp[n];
       
}
}

https://leetcode.com/problems/unique-paths/
Memoization
class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                dp[i][j] = -1;
            }
        }
        return uniquePathsHelper(m-1,n-1,m,n,dp);
    }
    
    public int uniquePathsHelper(int i,int j,int m, int n,int dp[][])
    {
        
        if(i == 0 && j == 0)
            return 1;
        if(i <0 || j < 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int left = uniquePathsHelper(i,j-1,m,n,dp);
        int   up = uniquePathsHelper(i-1,j,m,n,dp);
        
        return dp[i][j] = left + up;
    }
}


Tabulation
class Solution {
    // tabulation
    public int uniquePaths(int m, int n) {
        
       
        
        int dp[][] = new int[m][n];
        
      
        
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n;j++)
            {
                if(i ==0 && j ==0 )
                {
                     dp[0][0] = 1;
                    continue;
                }
                   
               
                    int up = 0;
                    int left = 0;
                    
                    if(i>0) 
                        up = dp[i-1][j];
                    if(j>0)
                       left = dp[i][j-1];
                    
                     dp[i][j] = left + up;
                
                  
        
            
            }
        }
       
         return dp[m-1][n-1];   
       
    }
    
   
}

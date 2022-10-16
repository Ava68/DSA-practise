class Solution {
    // memoization
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robhelper(nums.length-1,nums,dp);
    }
    
    public int robhelper(int ind,int nums[],int dp[])
    {
        if(ind == 0)
            return nums[ind];
        
        if(ind < 0)
            return 0;
        
        if(dp[ind] != -1)
            return dp[ind];
        
        
       int pick =  nums[ind] + robhelper(ind-2,nums,dp);
       int  notpick = robhelper(ind-1,nums,dp);
        
        return dp[ind] = Math.max(pick,notpick);
    }
}

// tabulation
public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        
        dp[0] = nums[0];
        
            
        for(int i =1; i<nums.length; i++)
        {
            // handing base case
            int pick =  nums[i] ;
            if(i>1)
                pick = pick + dp[i-2];
                 
             int  notpick = dp[i-1];
            
            dp[i] = Math.max(pick,notpick);
        }
            
            return dp[nums.length-1];
    }

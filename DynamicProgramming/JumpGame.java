https://leetcode.com/problems/jump-game/description/?envType=study-plan&id=dynamic-programming-i

// memoization
class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
    public boolean helper(int n, int nums[],int dp[]){  
        if(n >= nums.length-1)
            return true;
        if(nums[n] == 0)
            return false; 
        if(dp[n] != -1)
            return dp[n] == 1;
        for(int i =1; i<=nums[n]; i++){
            if(helper(n+i,nums,dp)){
                dp[n] = 1;
                return true;
            }
                
        }
        dp[n] = 0;
        return false;
    }
}

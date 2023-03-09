class Solution {
    // Intution is simple take the freq of all the numbers present pass the maximum not at the start of the req call. and at the time of rec call you wil have 2 option - take and not take

    // take -> nums[n] * freq -> then we can call it from n-2(because n-1 we don't need')
    // nottake -> directely call n-1 
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>maxi)
                maxi=nums[i];
        }
        int freq[] = new int[maxi+1];
        for(int i=0;i<n;i++){
            int num=nums[i];
            freq[num]++;
        }
        int dp[] = new int[maxi+1];
        Arrays.fill(dp,-1);
        return helper(maxi,freq,dp);
    }
    public int helper(int n,int freq[],int dp[]){
        if(n<= 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];

        int take= n*freq[n];
        if(n>1)
             take+=helper(n-2,freq,dp);
    
        int nottake=helper(n-1,freq,dp);
    
        return dp[n] = Math.max(take,nottake);
        
       
    }
}

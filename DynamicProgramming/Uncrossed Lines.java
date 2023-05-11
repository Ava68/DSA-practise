
// Memoization solution

https://leetcode.com/problems/uncrossed-lines/description/
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for(int i =0; i<nums1.length; i++){
            for(int j =0; j<nums2.length; j++)
                dp[i][j] = -1;
        }
        return helper(nums1.length-1,nums2.length-1,nums1,nums2,dp);
    }

    public int helper(int i,int j, int nums1[],int nums2[],int dp[][]){

        if(i <0 || j <0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        if(nums1[i] == nums2[j])
            return 1 + helper(i-1,j-1,nums1,nums2,dp);

        int left = 0;
        int right = 0;
        
        left = helper(i-1,j,nums1,nums2,dp);
        right = helper(i,j-1,nums1,nums2,dp);

        return dp[i][j] = Math.max(left,right);
    }
}

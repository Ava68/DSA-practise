https://leetcode.com/problems/minimize-maximum-of-array/description/

soln doubt-> https://www.youtube.com/watch?v=DAQHXe1yNtM

class Solution {

    public boolean isPossible(int x,int nums[])
    {
        long pre_sum = 0;
        for(int i =0; i<nums.length; i++){
            pre_sum += nums[i];

            if(pre_sum > (long)x * (i+1) )
                return false;
        }
        return true;
    }

    public int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = Integer.MIN_VALUE;

        for(int i =0; i<nums.length; i++){
            right = Math.max(right,nums[i]);
        }
        int ans = 0;
        while(left < right)
        {
            int mid = (left + right)/2;

            if(isPossible(mid,nums)){
                right = mid;
            }
            else
                left = mid+1;
                
        }
        return left;
    }
}

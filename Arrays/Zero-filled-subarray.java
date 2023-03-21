https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long countZero = 0;
        long res = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 0){
                countZero++;
            }
            else
            {
                res += (countZero*(countZero + 1))/2; // using formula n(n+1)/2 for finding subarray
                countZero = 0;
            }
        }
        if(countZero > 0)
            res += (countZero*(countZero + 1))/2;

        return res;
    }
}

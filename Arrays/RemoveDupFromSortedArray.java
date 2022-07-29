

https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int unique = 0;
        
        for(int i =0; i<nums.length; i++)
        {
            if( i > 0 && nums[i] == nums[i-1] )
            {
                continue;
            }
            
            else
            {
                nums[unique++] = nums[i];
                
            }
        }
        
        return unique;
        
    }
}

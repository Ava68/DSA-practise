
https://leetcode.com/problems/single-element-in-a-sorted-array/

// Brute Force soln
o(n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        
        if(nums.length == 1 || nums.length == 2)
            return nums[0];
        
      
        while(low<=high)
        {
            if(nums[low] != nums[low+1])
            {
                return nums[low];
            }
            if(nums[high] != nums[high-1])
            {
                return nums[high];
            }
            
            low = low+2;
            high = high-2;
        }
        
        
        return -1;
    }
}


// optimal Binary search
o(logn)
  
  class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        
        int low = 0;
        int high = nums.length-1;
        
        while(low < high)
        {
            int mid = (low + high)/2;
            
            // check for left part
      if( (mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 != 0 && nums[mid] == nums[mid-1]))
                low = mid+1;
            
            else
                high = mid;
            
           
            
        }
        
        return nums[low];
    }
}

/* algorithm is simple
we need to find the middle part 

there are 2 parts left part and right part

1,1,  |   2,3,3,4,4,8,8
leftP       rightP


left part
    1st occ even
    2nd occ odd
Right part
    1st occ odd
    2nd occ even

whenever low crosses right return nums[low]
*/



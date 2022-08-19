https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(nums[mid] == target)
                    return mid;
            
            // left half sorted
            if(nums[low] <= nums[mid])
            {
                
                // checking for the range(existence of the element or not)
                if(nums[low] <= target && nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            
            // right half sorted
            else
            {
                // checking for range(exisyence of the element or not)
                if(nums[mid] < target && nums[high] >= target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        
        return -1;
        
    }
}

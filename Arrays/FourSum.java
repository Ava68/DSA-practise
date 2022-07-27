https://leetcode.com/problems/4sum/submissions/

class Solution
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        // O(n^3) time | O(1) space
        Arrays.sort(nums);
        
        List<List<Integer>> myList = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i <= n - 4; i++)
        {
            // processing duplicates from num1
            if(i > 0 && nums[i] == nums[i-1])   continue;
            
            for(int j = i+1; j <= n - 3; j++)
            {
                // processing duplicates from num2
                if(j > i+1 && nums[j] == nums[j - 1])  continue;
                
                int left = j + 1, right = n - 1;
                
                // prevent integer overflow
                long diff = (long) target - (nums[i] + nums[j]);
                
                while(left < right)
                {
                    if(nums[left] + nums[right] > diff)
                        right--;
                    else if(nums[left] + nums[right] < diff)
                        left++;
                    else
                    {
                        myList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // processing duplicates from num3
                        while(left < right && nums[left] == nums[left + 1])   left++;
                        // processing duplicates from num4
                        while(left < right && nums[right] == nums[right - 1])   right--;
                        
                        left++;
                        right--;
                    }
                }
            }
        }
        return myList;
    }
}

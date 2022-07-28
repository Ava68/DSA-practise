https://leetcode.com/problems/longest-consecutive-sequence/submissions/


Brute Force 
tc - o(n)logn because we have performed sorting operation here

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Arrays.sort(nums);
        
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        
      
        int c = 1;
        int max = 1;
        for(int i =0; i<nums.length-1; i++)
        {
            
            
            if(nums[i+1] == 1+ nums[i] )
                c++;
            
            else if(nums[i+1] == nums[i])
                continue;
            
            else
                c = 1;
            
             max = Math.max(max,c);
           
            
            System.out.println(c);
        }
        
        return max;
    }
}

optimal solution

tc -> o(n)
  
  class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer>set = new HashSet<Integer>();
        
        if(nums.length == 0)
            return 0;
        
        for(int num:nums)
            set.add(num);
        
        int max = 1;
        
        for(int i =0; i<nums.length; i++)
        {
            int currele = nums[i];
            int currlen = 1;
            
            if(set.contains(currele-1) )
            {
                continue;
            }
            
            else
            {
                while(set.contains(currele + 1))
                {
                    currlen++;
                    currele = currele+1;
                    max = Math.max(max,currlen);
                }
            }
        }
        
        return max;
        
    }
}

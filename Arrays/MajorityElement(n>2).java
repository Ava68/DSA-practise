

Brute Force tc- o(n^2)

class Solution {
    public int majorityElement(int[] nums) {
        
        for(int i =0; i<nums.length; i++)
        {
            int count = 0;
            for(int j = i+1; j<nums.length; j++)
            {
                if(nums[i] == nums[j])
                    count++;
            }
            
            if(count >= nums.length / 2)
                return nums[i];
        }
        
        return -1;
    }
}

Better using Hashmaps.  tc - o(n) sc - o(n)
 
class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        // edge case
        if(nums.length == 1)
            return nums[0];
        
        for(int i =0; i<nums.length; i++)
        {
            
            
            if(map.containsKey(nums[i]))
            {
                if(map.get(nums[i]) +1 > nums.length/2)
                    return nums[i];
                
                else
                {
                    map.put(nums[i] , map.get(nums[i]) +1 );
                }
                    
            }
               
            else
                map.put(nums[i]  , 1);
            
             
             
            
        }
        
        return -1;
    }
}

Optimal more voting algo  tc - o(n) sc - o(1)
  
  class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        
        int ele = nums[0];
        for(int i =0; i<nums.length; i++)
        {
            
            if(ele == nums[i])
            {
                count ++;
            }
            
            else
                count --;
            
            if(count <= 0)
            {
                ele = nums[i];
                count = 1;
            }
        }
        
        return ele;
    }
}


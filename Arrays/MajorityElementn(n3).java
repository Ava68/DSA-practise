https://leetcode.com/problems/majority-element-ii/submissions/

Brute Force

tc - o(n) sc - o(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        HashSet<Integer>res = new HashSet<Integer>();
        
    HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        
        if(nums.length == 1)
        {
            res.add(nums[0]);
            
             List<Integer> arr = new ArrayList<>(res);
            return arr;
        }
        
        if(nums.length == 2 )
        {
            
             res.add(nums[0]);
            res.add(nums[1]);
            List<Integer> arr = new ArrayList<>(res);
            return arr;
        }
        
        for(int i =0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                if(map.get(nums[i]) + 1 > nums.length / 3)
                    res.add(nums[i]);
                
                else
                    map.put(nums[i] , map.get(nums[i]) +1);
            }
            
            else
                map.put(nums[i],1);
        }
        List<Integer> arr = new ArrayList<>(res);
        
        return arr;
    }
}

Optimal soln boyer's voting algo without using extra space 
  tc - o(n) sc - o(1)
  
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // we know 1 fact that in 1 array there only can be 2 majority ele at max
        
        int c1 = 0;
        int c2 = 0;
        int num1 = -1;
        int num2 = -1;
        
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == num1)
                c1++;
            
            else if(nums[i] == num2)
                c2++;
            
            else if(c1 == 0)
            {
                num1 = nums[i];
                c1 = 1;
            }
            
            else if(c2 == 0)
            {
                num2 = nums[i];
                c2 = 1;
            }
            else
            {
                c1--;
                c2--;
            }
                
        }
        
        // we need to actually check whether these are majority element are not
        
        int count1 = 0;
        int count2 = 0;
        
       for(int i =0; i<nums.length; i++)
       {
           if(nums[i] == num1 )
               count1++;
           
           else if(nums[i] == num2)
               count2++;
       }
        
        ArrayList<Integer>res = new ArrayList<Integer>();
        
        if(count1 > nums.length/3)
            res.add(num1);
    
        
         if(count2 > nums.length/3)
            res.add(num2);
        
        return res;
        
    }
}
        




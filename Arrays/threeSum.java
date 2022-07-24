https://leetcode.com/problems/3sum/ 

Brute Force soln

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        
        for(int i =0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                for(int k = j+1; k<nums.length; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        ArrayList<Integer>al = new ArrayList<Integer>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[k]);
                        
                        if(!res.contains(al))
                         res.add(al);
                    }
                }
            }
        }
        
        return res;
    }
}

Optimal soln

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new LinkedList<>();
        
        for(int i =0; i<nums.length-2; i++)
        {
              // check for repeatation
            if(i==0 || ( i>0 && nums[i] != nums[i-1] ))
               {
                   int lo = i+1;
                   int hi = nums.length-1;
                   
                   int sum = 0 - nums[i];
                   
                   while(lo < hi)
                   {
                       if(nums[lo] + nums[hi] == sum)
                       {
                           res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                           
                           // check for repeation 
                           while(lo <hi && nums[lo] == nums[lo+1])
                                   lo++;
                           
                           while(lo < hi && nums[hi] == nums[hi-1])
                                    hi--;
                           
                           lo++; hi--;
                       }
                       
                       // if the sum os not equal then it is in sorted order so we can skip the lo and hi accordingly.
                       else if(nums[lo] + nums[hi] < sum)
                           lo++;
                       else
                           hi--;
                           
                   }
               }
        
         }
  
    return res;
}
}



https://leetcode.com/problems/subsets-ii/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        subsetHelper(0,nums,res,new ArrayList<Integer>());
        
        return res;
    }
    
    public void subsetHelper(int ind,int [] nums,List<List<Integer>> res,List<Integer>sub)
    {
    
        
        res.add(new ArrayList<>(sub));
        
        if(ind >nums.length)
            return;
        
        
        for(int i =ind; i<nums.length; i++)
        {
            if(i!=ind && nums[i] == nums[i-1])
                continue;
            
            sub.add(nums[i]);
            subsetHelper(i+1,nums,res,sub);
            
            sub.remove(sub.size()-1);
        }
    }
}

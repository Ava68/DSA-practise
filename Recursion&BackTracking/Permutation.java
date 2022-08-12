https://leetcode.com/problems/permutations/submissions/

// Intution is clear if already visited the element so we will not visit at again 
// we should return when we have the size of ds equal to nums length

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        boolean flag [] = new boolean[nums.length];
        Arrays.fill(flag,false);
        
        List<List<Integer>> res = new ArrayList<>();
        
        permuteHelper(flag,nums,res,new ArrayList<Integer>());
        
        return res;
    }
    
    public void permuteHelper(boolean[] flag,int[] nums,List<List<Integer>> res,ArrayList<Integer>ds)
    {
        if(ds.size() == nums.length)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i =0; i<nums.length; i++)
        {
            if(flag[i] == true)
                continue;
            
            else {
            
                flag[i] = true;
                ds.add(nums[i]);
                
                permuteHelper(flag,nums,res,ds);
                
                ds.remove(ds.size()-1);
                flag[i] = false;
            }
                
            
        }
    }
}

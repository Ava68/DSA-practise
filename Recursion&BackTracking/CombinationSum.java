https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        combinationSumHelper(candidates,0,0,new ArrayList<Integer>(),res,target);
        
        return res;
    }
    
    public void combinationSumHelper(int[] candidates,int ind,int sum,List<Integer>ds,List<List<Integer>> res,int target)
    {
        
       if(ind == candidates.length)
        {
            if(sum == target)
            {
                res.add(new ArrayList<>(ds));
                return;
            }
            else
                return;
        }
        
        if(sum == target)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        else if(sum > target)
            return;
        
        sum += candidates[ind];
        ds.add(candidates[ind]);
        
        // take continously same element
        combinationSumHelper(candidates,ind,sum,ds,res,target);
        
        sum -= candidates[ind];
        ds.remove(ds.size()-1);
        // not take 
        combinationSumHelper(candidates,ind+1,sum,ds,res,target);
            
        
    }
}

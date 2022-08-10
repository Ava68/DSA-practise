https://leetcode.com/problems/combination-sum-ii/submissions/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // sort the array so we can find the unique (donot call recur for 1 guy multiple times)
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        
        combinationHelper(0,0,target,candidates,res,new ArrayList<Integer>());
        
        return res;
    }
    
    public void combinationHelper(int ind,int sum,int target,int[] candidates,List<List<Integer>> res,List<Integer>ds)
    {
        if(sum == target)
        {
            res.add(new ArrayList<>(ds));
        }
        else if(sum >target)
        {
            return;
        }
        
        for(int i =ind; i<candidates.length; i++)
        {
            if(i>ind && candidates[i] == candidates[i-1])
                continue;
            sum += candidates[i];
            ds.add(candidates[i]);
            
            combinationHelper(i+1,sum,target,candidates,res,ds);
            
            sum -= candidates[i];
            ds.remove(ds.size()-1);
        }
    }
}

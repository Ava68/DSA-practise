class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,ans,new ArrayList<>(),0);
        return ans;
    }

    public void helper(int [] nums,List<List<Integer>> ans,List<Integer> tmp,int indx)
    {
        if(indx >= nums.length)
        {
            ans.add(new ArrayList<>(tmp));
            indx--;
            return;
        }
        // take 
        tmp.add(nums[indx]);
        helper(nums,ans,tmp,indx+1);
        // backtracking we need to remove the element whatever we have added here
        tmp.remove(tmp.size()-1);
        // not take
        helper(nums,ans,tmp,indx+1); 
    }
}

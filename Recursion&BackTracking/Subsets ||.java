class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        /* sort is importnat because suppose we have a test case which is not sorted
        [4,1,4]
        it can generate subset like 414,41,4,14
        this why we need to sort the array to ensures that duplicate elements are adjacent to each other. 
        */
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        helper(nums,set,new ArrayList<Integer>(),0);
        for(List<Integer> tmp : set)
        {
            ans.add(new ArrayList<>(tmp));
        }
        return ans;
    }
    public void helper(int [] nums,HashSet<List<Integer>> set,ArrayList<Integer> tmp,int indx)
    {
        if(indx >= nums.length)
        {
            set.add(new ArrayList<>(tmp));
            indx--;
            return;
        }
        //take
        tmp.add(nums[indx]);
        helper(nums,set,tmp,indx+1);
        tmp.remove(tmp.size()-1);
        // not take
        helper(nums,set,tmp,indx+1);

    }
}

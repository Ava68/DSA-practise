class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();   
        helper(2*n,ans,n,n,"");
        return ans;
    }

    public void helper(int size,List<String> ans,int left, int right,String curr)
    {
        if(curr.length() == size)
        {
            ans.add(curr);
            return;
        }
        if(left > 0)
        {   
            helper(size,ans,left-1,right,curr+'(');
        }
         if(right > left)
         {
            helper(size,ans,left,right-1,curr+')');
         }
    }
}

https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        int count [] = new int[1];
        count[0] = 0;
        int ans[] = new int[1];
        ans[0] = 0;
        
        helper(root,k,count,ans);
        
        return ans[0];
    }
    
    public void helper(TreeNode root,int k,int count[],int ans[])
    {
        if(root == null)
            return ;
        
        
        helper(root.left,k,count,ans);
        count[0]++;
        if(count[0] == k)
           ans[0] = root.val;
        helper(root.right,k,count,ans);
    }
}

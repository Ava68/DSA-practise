https://leetcode.com/problems/balanced-binary-tree/submissions/

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        boolean flag[] = new boolean[1];
        flag[0] = true;
        helper(flag,root);
        return flag[0];
    }
    
    public int helper(boolean flag[],TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = helper(flag,root.left);
        int right = helper(flag,root.right);
        
        if(Math.abs(left - right) > 1)
            flag[0] = false;
        
        return 1 + Math.max(left,right);
    }
}

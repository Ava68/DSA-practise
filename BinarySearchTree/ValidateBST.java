https://leetcode.com/problems/validate-binary-search-tree/submissions/

class Solution {
    public boolean isValidBST(TreeNode root) {
        // long is to avoid Integer overflow
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root,long leftRange,long rightRange)
    {
        
        if(root == null)
            return true;
        
        if(root.val <= leftRange || root.val >= rightRange)
            return false;
        
        return helper(root.left,leftRange,root.val) && helper(root.right,root.val,rightRange);   
    }
}

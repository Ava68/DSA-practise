https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/


class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE);
        
    }
    
    public TreeNode helper(int[] preorder, int bound)
    {
        if(i == preorder.length || preorder[i] > bound)
            return null;
        
        TreeNode root = new TreeNode(preorder[i++]);
        
        root.left = helper(preorder,root.val);
        root.right = helper(preorder,bound);
        
        return root;
    }
}

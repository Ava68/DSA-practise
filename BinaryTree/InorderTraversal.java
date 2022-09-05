https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>ans = new ArrayList<Integer>();
        helper(root,ans);
  
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer>ans )
    {
        if(root == null)
            return;
        
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
}

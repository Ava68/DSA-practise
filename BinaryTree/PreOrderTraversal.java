https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer>ans = new ArrayList<Integer>();
        helper(root,ans);
  
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer>ans )
    {
        if(root == null)
            return;
        ans.add(root.val);
        helper(root.left,ans);
        helper(root.right,ans);
    }
}

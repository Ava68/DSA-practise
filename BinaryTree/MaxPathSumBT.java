/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxPath[] = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        
        helper(maxPath,root);
        
        return maxPath[0];
        
    }
    
    public int helper(int [] maxPath, TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = helper(maxPath,root.left);
        int right = helper(maxPath,root.right);
        
        maxPath[0] = Math.max(maxPath[0], left+right+root.val);
        
        return Math.max(0,Math.max(left,right) + root.val);
    }
}

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
    public int goodNodes(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = 0;
        helper(root,ans,root.val);
        return ans[0];
    }
    public void helper(TreeNode root,int ans[], int max)
    {
        if(root == null)
            return;
        if(root.val >= max)
            ans[0]++;
        helper(root.left,ans,Math.max(max,root.val));
        helper(root.right,ans,Math.max(max,root.val));
    }
}

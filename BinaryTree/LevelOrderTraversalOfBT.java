https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> mainlist = new ArrayList<>();
        
        if(root == null)
            return mainlist;
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        q.offer(root);
        
        
        while(!q.isEmpty())
        {    
            int size = q.size();
            List<Integer>sublist = new ArrayList<>();
            
            for(int i =0; i<size; i++)
            {
                TreeNode currNode = q.poll();
                
                sublist.add(currNode.val);
                
                if(currNode.left != null)
                    q.offer(currNode.left);
                
                if(currNode.right != null)
                    q.offer(currNode.right);
                
            }
            
            mainlist.add(sublist);
            
            
        }
        
        return mainlist;
    }
}

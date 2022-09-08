https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/

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

class Pair{
    
    int indx;
    TreeNode node;
    
    Pair(int indx, TreeNode node)
    {
        this.indx = indx;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0,root));
        
        int max = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int start = 0;
            int end = 0;
            
            for(int i =0; i<size; i++)
            {
                Pair p = q.poll();
                int currIndx = p.indx;
                TreeNode node = p.node;
                
                if(i == 0)
                    start = currIndx;
                if(i == size-1)
                    end = currIndx;
                
                if(node.left != null)
                    q.add(new Pair( (2  *currIndx) + 1, node.left));
                
                if(node.right != null)
                    q.add(new Pair( (2  *currIndx) + 2, node.right));
                
            }
            
            max = Math.max(max, (end+1 - start));
        }
        
        return max;
    }
}

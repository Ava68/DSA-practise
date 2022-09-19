


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

// Much Better Solution tc wise

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
    public int kthSmallest(TreeNode root, int k) {
        
        int count [] = new int[1];
        count[0] = 0;
        int ans[] = new int[1];
        ans[0] = 0;
        
        helper(root,k,count,ans);
        
        return ans[0];
    }
    
    public boolean helper(TreeNode root,int k,int count[],int ans[])
    {
        if(root == null)
            return false;
        
        
        if(helper(root.left,k,count,ans) == true)
            return true;
        
        count[0]++;
        if(count[0] == k)
        {
            ans[0] = root.val;
            return true;
        }
           
        if(helper(root.right,k,count,ans) == true)
            return true;
        
        return false;
    }
}


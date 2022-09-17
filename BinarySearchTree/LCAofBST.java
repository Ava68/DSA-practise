https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


brute force lca normal method

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // lowest common ancestor of a binary tree without using bst property
        if(root == null)
            return null;
        if(root == p)
            return p;
        
        if(root == q)
            return q;
        
        TreeNode lca1 = lowestCommonAncestor(root.left,p,q);
        TreeNode lca2 = lowestCommonAncestor(root.right,p,q);
        
        if(lca1 != null && lca2 != null)
            return root;
        if(lca1 != null)
            return lca1;
        
        else
            return lca2;
        
    }

optimal soln BST method

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }
}





Iterative Soln

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode curr = root;   
        while(curr != null)
        {
            if(curr.val == val)
                return curr;
            
            if(curr.val > val)
                curr = curr.left;
            else 
                curr =  curr.right;
        }
        return null;
    }
}

Recursive Soln

class Solution {
    TreeNode curr = null;
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null)
            return null;
        
        if(root.val < val)
            searchBST(root.right,val);
        else if(root.val > val)
            searchBST(root.left,val);
        
        else
            return curr = root;
        return curr;
    }
}

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        Map<Integer,Integer> inmap = new HashMap<Integer,Integer>();
        
        for(int i =0; i<inorder.length; i++)
            inmap.put(inorder[i],i);
        
        TreeNode root = constructTree(preorder,0,preorder.length-       1,inorder,0,inorder.length-1,inmap);
        
        return root;
        
        
    }
    
    public TreeNode constructTree(int [] preorder,int preStart,int preEnd,int [] inorder, int inStart, int inEnd, Map<Integer,Integer> inmap)
        
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = inmap.get(root.val);
        int numleft = inRoot - inStart;
        
        root.left = constructTree(preorder,preStart+1,preStart+numleft,inorder,inStart,inRoot-1,inmap);
        
        root.right = constructTree(preorder,preStart+numleft+1,preEnd,inorder,inRoot+1,inEnd,inmap);
        
        return root;
    }
}

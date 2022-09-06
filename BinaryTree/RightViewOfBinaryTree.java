https://leetcode.com/problems/binary-tree-right-side-view/ 


public void rightView(TreeNode root , ArrayList<Integer>al, int level)
    {
        if(root == null)
            return ;
        
        if(al.size() == level)
            al.add(root.val);
        
        rightView(root.right,al,level+1);
        rightView(root.left,al,level+1);
        
        
    }

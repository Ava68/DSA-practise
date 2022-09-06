https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> res = new ArrayList<Integer>();
      
      helper(0,res,root);
      
      return res;
    }
    
    public void helper(int maxlevel,ArrayList<Integer> res,Node root)
    {
        
        if(root == null)
            return;
            
        if(maxlevel == res.size())
            res.add(root.data);
            
        helper(maxlevel+1,res,root.left);
        helper(maxlevel+1,res,root.right);
        
    }
}

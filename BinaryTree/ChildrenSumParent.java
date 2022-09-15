https://practice.geeksforgeeks.org/problems/children-sum-parent/1


class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        int ans[] = new int[1];
        ans[0] = 1;
        
        helper(root,ans);
        return ans[0];
        
    }
    
    public static int helper(Node root,int ans[])
    {
        
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
            
        int left = helper(root.left,ans);
        int right = helper(root.right,ans);
        
        if(root.data != left + right)
            ans[0] = 0;
            
        return root.data;
        
    }
}

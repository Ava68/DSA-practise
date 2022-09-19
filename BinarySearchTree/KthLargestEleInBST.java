https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
 
         int count [] = new int[1];
        count[0] = 0;
        int ans[] = new int[1];
        ans[0] = 0;
        
        helper(root,K,count,ans);
        
        return ans[0];
    }
    
    public void helper(Node root,int k, int [] count,int ans[])
    {
        if(root == null)
            return ;
        
        
        helper(root.right,k,count,ans);
        count[0]++;
        if(count[0] == k)
           ans[0] = root.data;
        helper(root.left,k,count,ans);
    }
}

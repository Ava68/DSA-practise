
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
Brute Force ____>(path finding)

class Solution {
    
    Implementation------>> 1 finding path1 and path 2 from root to given node and out last equal element will be answer
    
    This Implementation also takes cares when key is not present in the binary tree in that case we return null
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       List<TreeNode>p1 = new ArrayList<TreeNode>();
       List<TreeNode>p2 = new ArrayList<TreeNode>();
        
       if( pathfinder(p1,root,p) == false || pathfinder(p2,root,q) == false)
                    return null;
        
        int i = 0;
        int j = 0;
        
       while(i<p1.size() && j<p2.size())
       {
           if(p1.get(i) == p2.get(j))
           {              
               i++;
               j++;
           }
           
           else
               break;        
       }      
        return p1.get(i-1);    
    }
    
    public boolean pathfinder(List<TreeNode>path,TreeNode root, TreeNode x)
    {
        if(root ==null)
            return false;
        
        path.add(root);
        if(root == x)
            return true;
       if(pathfinder(path,root.left , x) || pathfinder(path,root.right ,x))
           return true;
        
        path.remove(path.size()-1);
        
        return false;
        
    }

Optimal soln

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        
        if(root == p || root == q)
            return root;
        
       TreeNode lca1 =  lowestCommonAncestor(root.left,p,q);
       TreeNode lca2 =  lowestCommonAncestor(root.right, p,q);
        
        if(lca1 != null && lca2 != null)
            return root;
        
        if(lca1 == null)
            return lca2;
        else
            return lca1;
    }
}
  
  

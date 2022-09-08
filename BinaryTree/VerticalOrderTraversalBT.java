https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

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

class Pair implements Comparable<Pair>{
    
    int hd;
    TreeNode node;
    int level;
    
    Pair(int hd, TreeNode node, int level)
    {
        this.hd = hd;
        this.node = node;
        this.level = level;
    }
    
    @Override
        public int compareTo(Pair obj) {
            
            if (this.level == obj.level)
            return this.node.val - obj.node.val;
            
            return this.level - obj.level;
        }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
    TreeMap<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
        
        helper(map,root);
        
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet() )
        {
            List<Integer>sublist = entry.getValue();
            
            System.out.println(sublist);
            ans.add(sublist);
        }
             
        
        return ans;
        
    }
    
    public void helper( TreeMap<Integer,List<Integer>> map, TreeNode root)
    {
        PriorityQueue<Pair>q = new PriorityQueue<>();
        q.offer(new Pair(0,root,0));
        
        // map.put(0,new ArrayList<Integer>(root));
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int hd = p.hd;
            int level = p.level;
            TreeNode node = p.node;
            
            if(map.containsKey(hd))
            {
                 map.get(hd).add(node.val);
            }
                           
            else
            {
                ArrayList<Integer>al = new ArrayList<Integer>();
                  al.add(node.val);
                  map.put(hd,al);
            }
    
               
            
            if(node.left != null)
                q.offer(new Pair(hd-1, node.left,level+1));
            
            if(node.right != null)
                q.offer(new Pair(hd+1, node.right,level+1));
            
        }
        
    }
}

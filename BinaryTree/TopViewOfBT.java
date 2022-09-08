https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

class Pair{
    int hd;
    Node node;
    
    Pair(int hd,Node node)
    {
        this.hd = hd;
        this.node = node;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer>ans = new ArrayList<Integer>();
        
        TreeMap<Integer,Node>map = new TreeMap<Integer,Node>();
        
        helper(map,root);
        
        for (Map.Entry<Integer, Node> entry : map.entrySet())
             ans.add(entry.getValue().data);
        return ans;
    }
    
    public static void helper(TreeMap<Integer,Node>map, Node root )
    {
        map.put(0,root);
        Queue<Pair>q = new LinkedList<Pair>();
        
        q.offer(new Pair(0,root));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int hd = p.hd;
            Node node = p.node;
            
            if(!map.containsKey(hd))
                map.put(hd,node);
            
            if(node.left != null)
                q.offer(new Pair(hd-1,node.left));
                
            if(node.right != null)
                q.offer(new Pair(hd+1,node.right));
                
            
        }
    }
}

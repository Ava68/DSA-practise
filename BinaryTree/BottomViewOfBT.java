https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

//User function Template for Java
class Pair{
    Node node;
    int hd;
    
    Pair(Node node, int hd)
    {
        this.node = node;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Map<Integer,Node> map = new TreeMap<Integer,Node>();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        
        helper(map,root);
        
        for (Map.Entry<Integer, Node> entry : map.entrySet())
            ans.add(entry.getValue().data);
            
        return ans;
        
    }
    
    public static void helper(Map<Integer,Node> map, Node root)
    {
        Queue<Pair>q = new LinkedList<Pair>();
        
        map.put(0,root);
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;
            
            map.put(hd,node);
            
            if(node.left != null)
                q.add(new Pair(node.left,hd-1));
                
            if(node.right != null)
                q.add(new Pair(node.right,hd+1));
        }
    }
}

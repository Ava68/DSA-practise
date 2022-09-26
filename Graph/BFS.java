https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        Queue<Integer>q = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty())
        {
            
            int node = q.poll();
            ans.add(node);
            
            for(int it:adj.get(node))
            {
                if(vis[it] == false)
                {
                    vis[it] = true;
                    q.add(it);
                    
                     
                }
                   
            }
        }
        
        return ans;
    }
}

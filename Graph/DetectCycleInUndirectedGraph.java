https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

Dfs soln

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        
        for(int i =0; i<V; i++)
        {
            if(vis[i] == false)
                if(dfsCheck(i,adj,vis,-1))
                 return true;
        }
        
        return false;
    }
    
    public boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],int parent)
    {
        vis[node] = true;
        
        for(int it:adj.get(node))
        {
            if(vis[it] == false)
            {
                if(dfsCheck(it,adj,vis,node) == true)
                    return true;
            }
            else if( it != parent)
                return true;
        }
        
        return false;
        
    }
}

BFS soln

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int parent[] = new int[V];
        boolean vis[] = new boolean[V];
        
        Queue<Integer>q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            
            for(int it:adj.get(node))
            {
                if(vis[it] == false)
                {
                    vis[it] = true;
                    parent[it] = node;
                    q.add(it);
                }
                else if(it !=  parent[node])
                    return true;
            }
        }
        
        return false;
    }
}

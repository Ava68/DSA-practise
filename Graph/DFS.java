https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer>ans = new ArrayList<Integer>();
        boolean vis[] = new boolean[V];
       Arrays.fill(vis,false);
        dfs(0,ans,adj,vis);
        
        return ans;
    }
    
    public void dfs(int node,ArrayList<Integer>ans, ArrayList<ArrayList<Integer>> adj,  boolean vis[])
    {
        vis[node] = true;
       ans.add(node);
       
        for(int it:adj.get(node))
        {
            if(vis[it] == false)
                dfs(it,ans,adj,vis);
        }
    }
}

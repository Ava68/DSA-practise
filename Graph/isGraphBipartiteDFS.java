class Solution {
    public boolean isBipartite(int[][] graph) {
        
        
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i =0; i<graph.length; i++)
        {
            if(color[i] == -1)
                if(dfs(color,graph,i) == false)
                    return false;
        }
        
        return true;
            
    }
    public boolean dfs(int color[],int[][] graph, int node)
    {
        if(color[node] == -1)
           color[node] = 0;
        
        for(int it: graph[node])
        {
            if(color[it]  == -1)
            {
                color[it] = 1 - color[node];
                if(dfs(color,graph,it) == false)
                    return false;
            }
            
            else if(color[it] == color[node])
                return false;
        }
        
        return true;
    }
}

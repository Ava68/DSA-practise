https://leetcode.com/problems/is-graph-bipartite/
bfs soln

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        
        
        for(int i=0; i<graph.length; i++)
        {
            if(color[i] == -1)
               if(bfs(color,graph,i) == false)
                   return false;
        }
        
        return true;
    }
    
    public boolean bfs(int color[], int [][] graph,int node)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        color[node] = 0;
        q.add(node);
        
        while(!q.isEmpty())
        {
            int newNode = q.poll();
            
            for(int it: graph[newNode])
            {
                if(color[it] == -1)
                {
                    q.add(it);
                    color[it] = 1 - color[newNode];
                }
                else if(color[it] == color[newNode])
                    return false;
            }
        }
        
        return true;
    }
}

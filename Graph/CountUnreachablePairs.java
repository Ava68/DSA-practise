https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = (long)n;
        ans = (ans * (ans - 1))/2;

        List<List<int[]>> adj = new ArrayList<>();

        for(int i =0; i<=n; i++)
            adj.add(new ArrayList<>());

        for(int edge[]:edges){
            adj.get(edge[0]).add(new int[]{edge[1]});
            adj.get(edge[1]).add(new int[]{edge[0]});
        }
        boolean vis[] = new boolean[n];

        for(int i =0; i<n; i++){
            if(!vis[i]){
                long new_count [] = new long[1];
                new_count[0] = 0;
                dfs(i,adj,new_count,vis);
                ans = ans - ( new_count[0] * (new_count[0]-1) )/2;
            }
        }
        return ans; 
    }

    public void dfs(int src, List<List<int[]>> adj, long new_count[],boolean vis[])
    {
        vis[src] = true;
        new_count[0]++;

        for(int[] it:adj.get(src)){
            if(vis[it[0]] == false)
                dfs(it[0],adj,new_count,vis);
        }
    }
}

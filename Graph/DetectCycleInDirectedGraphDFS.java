dfs soln

https://leetcode.com/problems/course-schedule/submissions/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i<numCourses; i++)
                adj.add(new ArrayList<Integer>());
        for(int p[]: prerequisites)
        {
            adj.get(p[1]).add(p[0]);
        }
        
        boolean vis[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        
        Arrays.fill(vis,false);
        Arrays.fill(recStack,false);
        
        for(int i=0;i<numCourses;i++) {
            if(isCyclic(i, vis, adj,recStack)) {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean isCyclic(int node,  boolean vis[],ArrayList<ArrayList<Integer>> adj, boolean recStack[])
    {
        
        vis[node] = true;
        recStack[node] = true;
        
        for(int it:adj.get(node))
        {
            if(vis[it] == false)
            {
                
                if(isCyclic(it,vis,adj,recStack) == true)
                    return true;
            }
            else if(recStack[it] == true)
                return true;
        }
        
        recStack[node] = false;
        return false;
    }
        
}

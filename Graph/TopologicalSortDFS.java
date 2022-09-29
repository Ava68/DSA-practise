https://practice.geeksforgeeks.org/problems/topological-sort/1


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i =0; i<V; i++)
        {
            if(vis[i] == false)
                dfs(i,st,adj,vis);
        }
        
        int topo[] = new int[V];
        int indx = 0;
        while(!st.isEmpty())
        {
            topo[indx++] = st.pop();
        }
        return topo;    
    }
    
    static void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        vis[node] = true;
        
        for(int it:adj.get(node))
        {
            if(vis[it] == false)
                dfs(it,st,adj,vis);
        }
        st.push(node);
    }
}

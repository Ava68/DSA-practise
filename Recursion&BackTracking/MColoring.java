https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
       int color[] = new int[n];
       Arrays.fill(color,-1);
       
       if(solve(0,graph,n,m,color) == true)
        return true;
        
    return false;
    }
    
    public boolean solve(int node,boolean graph[][],int n, int m, int color[])
    {
        
        if(node == n)
            return true;
        for(int i =1; i<=m; i++)
        {
            if(isValid(node,graph,n,i,color) == true)
            {
                color[node] = i;
                
                if(solve(node+1,graph,n,m,color) == true)
                    return true;
                    
                    color[node] = -1;
                    
            }
        }
        
        return false;
    }
    
    public boolean isValid(int node,boolean[][] graph, int n, int m, int color[])
    {
       for(int i =0; i<n; i++)
       {
           // checking that particular color is valid or not
           if( (graph[node][i] == true || graph[i][node] == true) && 
                    (m == color[i]) )
                        return false;
       }
        
        return true;
    }
}

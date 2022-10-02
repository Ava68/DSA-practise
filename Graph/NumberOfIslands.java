class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        
        for(int i =0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                 vis[i][j] = false;
            }
               
        }
        
        int cnt = 0;
        for(int i =0; i<m; i++)
        {
            for(int j = 0; j<n; j++)   
            {
                if(vis[i][j] == false && grid[i][j] == '1')
                {
                    dfs(vis,grid,i,j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public void dfs( boolean vis[][], char[][] grid, int i, int j )
    {
        
        if(i <0 || i >= grid.length || j <0 || j >= grid[0].length || grid[i][j] == '0' || vis[i][j] == true )
            return;
        
        vis[i][j] = true;
        
        // up
        dfs(vis,grid,i-1,j);
        // down
        dfs(vis,grid,i+1,j);
        // left
        dfs(vis,grid,i,j-1);
        // right
        dfs(vis,grid,i,j+1);
    }
}

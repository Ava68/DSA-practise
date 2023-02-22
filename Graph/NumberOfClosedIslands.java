https://leetcode.com/problems/number-of-closed-islands/description/?envType=study-plan&id=graph-i

class Solution {
    public int closedIsland(int[][] grid) {
        // up down left right
        // intuition is to convert boundary and its reachable from boundary to 1
        // then we will be left with the closed island that is not been reachable from the boundary
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i =0; i<n; i++){
            if(grid[0][i] == 0)
                boundaryDFS(0,i,grid,dirRow,dirCol);
            if(grid[m-1][i] == 0)
                boundaryDFS(m-1,i,grid,dirRow,dirCol);
        }
        for(int i =0; i<m; i++){
            if(grid[i][0] == 0)
                boundaryDFS(i,0,grid,dirRow,dirCol);
            if(grid[i][n-1] == 0)
                boundaryDFS(i,n-1,grid,dirRow,dirCol);
        }
        
        int closedIslands = 0;

        
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,dirRow,dirCol);
                    closedIslands++;
                }

            }
        }     
       return closedIslands; 
    }
    public void dfs(int [][] grid,int i, int j,int dirRow[],int dirCol[])
    {
        grid[i][j] = 1;
        
        for(int k =0; k<4; k++){
            int newRow = i + dirRow[k];
            int newCol = j + dirCol[k];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length  && grid[newRow][newCol] == 0 )
                dfs(grid,newRow,newCol,dirRow,dirCol);
        }
    }
    public void boundaryDFS(int row,int col,int grid[][],int dirRow[], int dirCol[])
    {
        grid[row][col] = 1;

        for(int k =0; k<4; k++){
            int newRow = row + dirRow[k];
            int newCol = col + dirCol[k];

        if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length  && grid[newRow][newCol] == 0)
            boundaryDFS(newRow,newCol,grid,dirRow,dirCol);
            
        }
    }
}

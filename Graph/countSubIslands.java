https://leetcode.com/problems/count-sub-islands/description/

intution is very easy simultaneously traverse through both the grids by dfs and check they are same or not if(grid2[row][col] != grid1[row][col])

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // up down left right
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        int m = grid2.length;
        int n = grid2[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                vis[i][j] = false;
            }
        }

        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(vis[i][j] == false && grid2[i][j] == 1 && grid1[i][j] == 1){
                     boolean istrue[] = new boolean[1];
                     istrue[0] = true;
                     dfs(i,j,grid1,grid2,vis,istrue,dirRow,dirCol);
                     if(istrue[0] == true)
                        count++;
                }    
            }
        }
        return count; 
    }
    public boolean dfs(int row,int col,int grid1[][],int grid2[][],boolean vis[][],boolean istrue[],int dirRow[],int dirCol[])
    {
        vis[row][col] = true;
        if(grid2[row][col] != grid1[row][col])
            istrue[0] = false;
        
        for(int i =0; i<4; i++){
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if(newRow >=0 && newRow < grid2.length && newCol >=0 && newCol < grid2[0].length &&  vis[newRow][newCol] == false && grid2[newRow][newCol] == 1)
                if(!dfs(newRow,newCol,grid1,grid2,vis,istrue,dirRow,dirCol))
                    return false;
        }
        return true;
    }
}

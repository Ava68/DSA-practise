https://leetcode.com/problems/max-area-of-island/description/?envType=study-plan&id=graph-i

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // up down left right
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];

        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
                vis[i][j] = false;
        }
        int max = 0;

        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(vis[i][j] == false && grid[i][j] == 1)
                {
                    int count[] = new int[1];
                    count[0] = 0;
                    dfs(grid,i,j,vis,dirRow,dirCol,count);
                    System.out.println(count[0]);
                    max = Math.max(max,count[0]);
                }
            }
        }
        return max;

    }

    public void dfs(int grid[][],int i,int j, boolean vis[][], int dirRow[], int dirCol[],int count[])
    {
        vis[i][j] = true;
        count[0]++;

        for(int k =0; k<4; k++)
        {
            int newRow = i + dirRow[k];
            int newCol = j + dirCol[k];

            if( newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && 
            vis[newRow][newCol] == false && grid[newRow][newCol] == 1)
                 dfs(grid,newRow,newCol,vis,dirRow,dirCol,count);
        }
    }
}

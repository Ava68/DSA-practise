https://leetcode.com/problems/number-of-enclaves/submissions/903493338/?envType=study-plan&id=graph-i

class Solution {
    public int numEnclaves(int[][] grid) {
        //Intuition is to traverse to the boundary of the grid and make it 0 by calling dfs to every node
        // then count the number of remaining 1 is available in the grid
        //up down left right
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0; i<n; i++){
            if(grid[0][i] == 1)
                boundaryDfs(0,i,grid,dirRow,dirCol);
            if(grid[m-1][i] == 1)
                boundaryDfs(m-1,i,grid,dirRow,dirCol);
        }
        for(int i =0; i<m; i++){
            if(grid[i][0] == 1)
                boundaryDfs(i,0,grid,dirRow,dirCol);
            if(grid[i][n-1] == 1)
                boundaryDfs(i,n-1,grid,dirRow,dirCol);
        }
        int count = 0;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1)
                    count++;
            }
        }
    return count;

    }

    public void boundaryDfs(int row,int col,int grid[][],int dirRow[],int dirCol[])
    {
        grid[row][col] = 2;

        for(int i =0; i<4; i++){
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1)
                boundaryDfs(newRow,newCol,grid,dirRow,dirCol);
        }

    }
}

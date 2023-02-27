https://leetcode.com/problems/shortest-bridge/description/?envType=study-plan&id=graph-i

class Solution {
    // Intuition is to find  the 1st island cordinates and add it into the queue and change from 1 to 2 via dfs 
    // then call bfs and incremenet every time if you reach to another island immediately return
    public int shortestBridge(int[][] grid) {
        int dirRow[] = {-1,1,0,0};
        int dirCol [] = {0,0,-1,1};
        Queue<int[]>queue = new LinkedList<>();
        label:
        for(int i =0; i<grid.length; i++){
            for(int j =0; j<grid.length; j++)
            {
                if(grid[i][j] == 1){
                   dfsMakeTwo(i,j,grid,dirRow,dirCol,queue);
                   break label;
                }
            }
        }
        int step = 0;
        int min = Integer.MAX_VALUE;
      while(!queue.isEmpty())
      {
          int size = queue.size();
          for(int i =0; i<size; i++)
          {
              int pop[] = queue.poll();
              for(int k =0; k<4; k++){
                  int newRow = pop[0] + dirRow[k];
                  int newCol = pop[1] + dirCol[k];

                  if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid.length && grid[newRow][newCol] != 2) {
                  if (grid[newRow][newCol] == 1) 
                            return step;  
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
              }
          
            }
        }
        step++;
      }
        return -1;

    }

    public void dfsMakeTwo(int row,int col,int[][] grid,int dirRow[],int dirCol[],Queue<int[]>queue)
    {
        grid[row][col] = 2;
        queue.offer(new int[]{row,col});
        for(int i =0; i<4; i++){
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if(newRow >=0 && newRow < grid.length && newCol >= 0 && newCol < grid.length && grid    [newRow][newCol] == 1)
                dfsMakeTwo(newRow,newCol,grid,dirRow,dirCol,queue);
            
        }
    }
    
}

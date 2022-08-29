https://leetcode.com/problems/rotting-oranges/submissions/

BFS Algo

class Pair{
    int row;
    int col;
    int tm;
    
    Pair(int row,int col,int tm)
    {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<Pair>();
        int vis[][] = new int[n][m];
        int cntfresh = 0;
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
                else
                    vis[i][j] = 0;
                
                if(grid[i][j] == 1)
                    cntfresh++;
            }
        }
        
        int tm = 0;
        
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,1,0,-1};
        
        int cnt  = 0;
        
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            
            tm = Math.max(tm,t);
            q.remove();
            
            for(int i =0; i<4; i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                if( nrow < n && nrow >= 0 && ncol < m && ncol >=0 && vis[nrow][ncol] == 0                                 && grid[nrow][ncol] == 1 )
                {
                     q.add(new Pair(nrow,ncol,t+1));
                     vis[nrow][ncol] = 2;
                     cnt++;
                }
                   
            }
            
        }
        
        if(cnt != cntfresh)
            return -1;
        return tm;
      
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Intutuon is to find which all are 0 elements then push it into our queue first then traverse through the queue 
      //and apply simple bfs algo. take 1 visited array
        int m = mat.length;
        int n = mat[0].length;
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        boolean vis[][] = new boolean[m][n];
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty())
        {
            int pop[] = queue.poll();

            for(int i =0; i<4; i++){
                int newRow = pop[0] + dirRow[i];
                int newCol = pop[1] + dirCol[i];

                if(newRow >=0 && newRow <m && newCol >=0 && newCol <n && vis[newRow][newCol] == false){
                    mat[newRow][newCol] = 1 + mat[pop[0]][pop[1]];
                     vis[newRow][newCol] = true;
                    queue.add(new int[]{newRow,newCol});
                }
                
            }
        }
        
        return mat;
    }
}

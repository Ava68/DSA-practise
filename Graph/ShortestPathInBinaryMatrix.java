
https://leetcode.com/problems/shortest-path-in-binary-matrix/description/?envType=study-plan&id=graph-i
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //up down left right leftup rightup leftbottom rightbottom
        int dirRow[] = {-1,1,0,0,-1,-1,1,1};
        int dirCol[] = {0,0,-1,1,-1,1,-1,1};
        boolean visited[][] = new boolean[grid.length][grid.length];
        int dist[][] = new int[grid.length][grid.length];
       
        
        dist[0][0] = 0;
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        if(grid[0][0] == 1)
            return -1;

        while(!queue.isEmpty()){
            int[] pop = queue.remove();

            for(int i =0; i<8; i++){
                int nextI = pop[0] + dirRow[i];
                int nextJ = pop[1] + dirCol[i];

                if(nextI>=0 && nextI<grid.length && nextJ>=0 && nextJ<grid.length && !visited[nextI][nextJ] && grid[nextI][nextJ]==0){
                     dist[nextI][nextJ] = 1 + dist[pop[0]][pop[1]];
                     visited[nextI][nextJ] = true;
                     queue.add(new int[]{nextI,nextJ});
                }
            }
            
        }
        if(dist[grid.length-1][grid.length-1] != 0 || grid.length == 1)
            return 1 + dist[grid.length-1][grid.length-1];
        return  -1;
        

    }
}

2nd solution -->
    
    private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pop = queue.remove();
                if(pop[0]==m-1 && pop[1]==n-1) {
                    return ans+1;
                }
                for (int k=0;k<8;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }

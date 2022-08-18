https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        int vis[][] = new int[n][n];
        
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {
                vis[i][j] = 0;
            }
        }
        
        int di[] = {1,0,0,-1};
        int dj[] = {0,-1,+1,0};
        
        ArrayList<String>res = new ArrayList<String>();
        
        if(m[0][0] == 1)
            solve(m,n,vis,di,dj,res,"",0,0);
        
        return res;
        
    }
    
    public static void solve(int[][] m, int n, int vis[][],int di[],int dj[], ArrayList<String>res, String move,int i,int j )
    
    {
        if(i == n-1 && j ==n-1)
        {
            res.add(move);
            return;
        }
        
        String dir= "DLRU";
        
        for(int ind =0; ind<4; ind++)
        {
            int nexti = i+ di[ind];
            int nextj = j + dj[ind];
            
            if(nexti >= 0 && nextj>=0 && nexti <n && nextj <n && 
            vis[nexti][nextj] == 0 && m[nexti][nextj] == 1)
            {
                vis[i][j] = 1;
                solve(m,n,vis,di,dj,res, move+dir.charAt(ind), nexti,nextj);
                vis[i][j] = 0;
            }
            
        }
    }
}

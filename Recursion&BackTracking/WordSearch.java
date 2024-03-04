class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){

           for(int j=0;j<board[0].length;j++){

                if(board[i][j]==word.charAt(0)){

                    if(helper(board,word,i,j,board[0].length,board.length,0))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][]board,String word,int row,int col,int m,int n,int idx){
       //base case
        if(idx == word.length()){
            return true;
        }
        // negetive base case
        if(row<0 || col<0 || row>=n || col>=m || board[row][col] != word.charAt(idx)){
            return false;
        }
        board[row][col]='*';//changes make for not going back on same place again

        int[]r={0,0,-1,1};
        int[]c={1,-1,0,0};
       //four recursion calls for up,down,left and right
        for(int i=0;i<c.length;i++){
            if(helper(board,word,row+r[i],col+c[i],m,n,idx+1))
                return true;
        }
        board[row][col]=word.charAt(idx);//backtrack
        return false;
    }
}

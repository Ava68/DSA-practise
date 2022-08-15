https://leetcode.com/problems/n-queens/submissions/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<>();
        
        char board[][] = new char[n][n];
        
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
                board[i][j] = '.';
        }
        
      // dfs call starting from oth column
        dfs(0,board,res,n);
        
        return res;
    }
    
    public void dfs(int col,char board[][],List<List<String>> res,int n)
    {
        if(col == n)
        {
            res.add(construct(board));
            return;
        }
        
      // iterating over rows
        for(int row =0; row<n; row++)
        {
          // checking if we can add queen at that position then ove to next column and also
            if(validate(row,col,board))
            {
                board[row][col] = 'Q';
                dfs(col+1,board,res,n);
                // backtracking
                board[row][col] = '.';
                
            }
        }
    }
    
  // constructing the list of strings
     public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
         
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    public boolean validate(int row,int col,char [][] board)
    {
        int duprow = row;
        int dupcol = col;
        
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(col>=0)
        {
            if(board[row][col] == 'Q')
                return false;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(row <board.length && col >= 0)
        {
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
                
        }
        
        return true;
    }
}

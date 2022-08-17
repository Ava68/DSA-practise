https://leetcode.com/problems/sudoku-solver/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board)
    {
        for(int i =0; i<board.length; i++)
        {
            for(int j =0; j<board[i].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1'; c<='9'; c++)
                    {
                        if(validate(i,j,c,board) == true)
                        {
                            board[i][j] = c;
                            
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                        
                        
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
     public boolean validate( int row, int col, char c,char [][] board){
         
        int regionRow = 3 * (row / 3);  //region starting row
        int regionCol = 3 * (col / 3);    //region starting col
         
        for (int i = 0; i < 9; i++) {
            
            if (board[i][col] == c) 
                return false; //check row
            if (board[row][i] == c) 
                return false; //check column
            
            if (board[regionRow + i / 3][regionCol + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}

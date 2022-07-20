https://leetcode.com/problems/rotate-image/submissions/

class Solution {
    
    public void rotate(int[][] matrix) {
        
        // transpose
        
        for(int i =0; i<matrix.length; i++)
        {
            for(int j =0 ;j<matrix[0].length; j++)
            {
                if(j > i)
                 {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    
                }
            }
        }
        
        // swap the matrix
        
        for(int i =0; i<matrix.length; i++)
        {
            int x = 0;
            int y = matrix[0].length-1;
            
            while(x<=y)
            {
                int temp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = temp;
                
                x++;
                y--;
            }
        }
        
        
    }
    
    
}

// first we need to transpose the matrix 
// then we can swap the column wise

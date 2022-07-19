// https://leetcode.com/problems/set-matrix-zeroes/submissions/

class Solution {
    public void setZeroes(int[][] matrix) {
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        
        for(int i =0; i<matrix.length; i++)
        {
            for(int j =0; j<matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    ArrayList<Integer>sublist = new ArrayList<Integer>();
                    sublist.add(i);
                    sublist.add(j);
                    al.add(sublist);
                }
            }
        }
        
         
        
        for (int i = 0; i < al.size(); i++)
        {
            int R = al.get(i).get(0);
            int C = al.get(i).get(1);
            
            // now we have i and j 
            // time to apply our leftmost and uppermost algorithm
            
            int leftmostR = R;
            int leftmostC = 0;
            
            // left most 
                for(int j = 0; j<matrix[0].length; j++)
                    matrix[leftmostR][j] = 0;
            
            int topmostR = 0;
            int topmostC = C;
            
            // top Most
            
                for(int j =0; j<matrix.length; j++)
                    matrix[j][topmostC] = 0;
                    
               
            
                
        }
    }
}

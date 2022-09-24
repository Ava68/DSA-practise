class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // up down left right
        int dirRow[] = {-1,1,0,0};
        int dirCol[] = {0,0,-1,1};
        
        floodFillHelper(image,sr,sc,color,dirRow,dirCol,image[sr][sc]);
        
        return image;
    }
    
    public void floodFillHelper(int[][] image, int sr, int sc, int newColor,int dirRow[],int dirCol[],int oldColor)
    {
        
        image[sr][sc] = newColor;
        
        for(int i =0; i<4; i++)
        {
            int newRow = sr + dirRow[i];
            int newCol = sc + dirCol[i];
            
            if( (newRow >= 0 && newRow < image.length) && (newCol >=0 && newCol < image[0].length) && (image[newRow][newCol] == oldColor) && (image[newRow][newCol] != newColor) )
            {
                floodFillHelper(image,newRow,newCol,newColor,dirRow,dirCol,oldColor);
            }
        }
    }
}

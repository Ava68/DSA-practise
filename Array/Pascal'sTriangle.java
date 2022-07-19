https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows == 0)
            return result;
        
        List<Integer>al = new ArrayList<Integer>();
        
        al.add(1);
        result.add(al);
        
        for(int i =1; i<numRows; i++)
        {
            if(i == 1)
            {
                List<Integer>al1 = new ArrayList<Integer>();
                al1.add(1);
                al1.add(1);
                result.add(al1);
            }
        else{
             List<Integer> prevList = result.get(i-1);
             List<Integer> currList = new ArrayList<Integer>();
            
            currList.add(1);
            
            for(int j =0; j<prevList.size()-1; j++)
            {
                int ind1 = prevList.get(j);
                int ind2 = prevList.get(j+1);
                
                currList.add(ind1+ind2);
                    
            }
            
            currList.add(1);
            
            result.add(currList);
        }
           
        }
        
        return result;
        
    }
}

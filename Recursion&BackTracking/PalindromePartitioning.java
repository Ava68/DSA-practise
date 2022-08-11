https://leetcode.com/problems/palindrome-partitioning/submissions/

class Solution {
    public List<List<String>> partition(String s) {
       
        List<List<String>> res = new ArrayList<>();
        
        partitionHelper(0,s,new ArrayList<String>(),res);
        
        return res;
    }
    
    public void partitionHelper(int ind,String s, ArrayList<String> ds,List<List<String>> res)
    {
        if(ind >= s.length())
        {
             res.add(new ArrayList<>(ds));
            return;
        }
                 
        for(int i =ind; i<s.length(); i++)
        {
            String temp = "";  
            temp = s.substring(ind,i+1);
            
            if(isPalindrome(temp))
            {
                ds.add(temp);
                partitionHelper(i+1,s,ds,res);
                ds.remove(ds.size()-1);
            }
            
                    
            
        }
    }
    
    public boolean isPalindrome(String a )
    {
        int i = 0;
        int j = a.length()-1;    
        while(i<j)
        {
            if(a.charAt(i) != a.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}

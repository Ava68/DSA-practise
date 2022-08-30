class Solution {
    public String reverseWords(String s) {
        
        //I'm splitting on the regex for one-or-more whitespace, this takes care of multiple spaces/tabs/newlines/etc in the input. Since the input could have leading/trailing whitespace, which would result in empty matches, I first trim the input string.
        
       
        String[] words = s.trim().split("\\s+");
        
        String ans = "";
        
        for(int i =words.length-1; i>=0; i--)
        { 
            ans += words[i];
            
          
            
            if(i != 0)
                ans += " ";
              
        }
        
        return ans;
    }
}

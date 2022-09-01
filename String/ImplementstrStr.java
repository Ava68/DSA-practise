https://leetcode.com/problems/implement-strstr/submissions/

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0)
            return 0;
        
        int i = 0;
        int j = 0;
        int pos  = 0; 
        while(i < haystack.length() && j < needle.length())
        {
            if(haystack.charAt(i++) == needle.charAt(j))
                j++;
            
            else
            {
                i = i - j;
                j = 0;
                pos = i;
            }
        }
        
        return j == needle.length() ? pos : -1;
        
    }
}

https://leetcode.com/problems/repeated-string-match/submissions/

class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int count = 1;
        
        String res = a;
        while(res.length() < b.length())
        {
            count++;
            res+=a;
        }
        
        if(res.indexOf(b) != -1)
            return count;
        
        res+=a;
        
        return res.indexOf(b) == -1 ? -1 : count+1;
        
    }
}

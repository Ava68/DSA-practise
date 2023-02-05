https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res = new ArrayList<Integer>();
        int hash[] = new int[26];
        int phash[] = new int[26];
        int window = p.length();
        int len = s.length();

        if(len<window)
            return res;
        int left =0,right =0;
        // first window
        while(right < window)
        {
            phash[p.charAt(right) - 'a'] +=1;
            hash[s.charAt(right) - 'a'] +=1;
            right++;
        }
        right-=1;
        while(right < len)
        {
            if(checkSame(phash,hash))
                res.add(left);
            right+=1;
            if(right != len)
                hash[s.charAt(right) - 'a']+=1;

             hash[s.charAt(left) - 'a'] -=1;
             left+=1;
        }

        return res;
    }
    public boolean checkSame(int phash[],int hash[])
    {
        for(int i =0; i<26; i++) 
        {
            if(phash[i] != hash[i])
                return false;
        }
        return true;
    }
}

https://leetcode.com/problems/longest-substring-without-repeating-characters/

optimal  Solution


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>hset=new HashSet<Character>();
            
            int i=0, j=0;
        int longestSubstring= 0;
        
        while(j<s.length())
        {
            if(!hset.contains(s.charAt(j)))
            {
                hset.add(s.charAt(j));
                longestSubstring=Math.max(longestSubstring,hset.size());
                j++;
            }
            
            else{
                hset.remove(s.charAt(i));
                i++;
            }
        }
        
        return longestSubstring;
            
    }
}

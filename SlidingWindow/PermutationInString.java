// Its an easy solution just sort the first string and then in each window sort that window string 
// and check both the string are equal or not

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        for(int i =0; i <= s2.length() - s1.length(); i++ )
        {
            String newS2 = sort(s2.substring(i, i + s1.length()) );
            if(s1.equals(newS2))
                return true;
        }
        return false;
    }

    public String sort(String s1)
    {
        char t[] = s1.toCharArray(); 
        Arrays.sort(t);
        return new String(t);
    }
}

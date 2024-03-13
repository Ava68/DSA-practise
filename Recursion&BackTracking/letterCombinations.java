class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] keypad={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> ans = new ArrayList<>();
        if(digits.equals("")){
            return ans;
        }
        helper(digits,keypad,ans,new StringBuilder(""),0);
        return ans;
    }
    public void helper(String digits, String[] keypad,List<String> ans,StringBuilder str,int idx)
    {

        if(idx == digits.length())
        {
            ans.add(str.toString());
            return;
        }

        int digit=digits.charAt(idx)-'0';
        for(int i=0;i<keypad[digit].length();i++)
        {
            str.append(keypad[digit].charAt(i));
            helper(digits,keypad,ans,str,idx+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}

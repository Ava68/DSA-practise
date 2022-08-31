https://leetcode.com/problems/roman-to-integer/submissions/
class Solution {
    
    public int FindNumber(char a)
    {
        switch(a)
        {
            case 'I' : return 1;
                
            case 'V' : return 5;

            case 'X' : return 10;
            
            case 'L' : return 50;
                
            case 'C' : return 100;
                
            case 'D' : return 500;
                
            case 'M' : return 1000;                         
        }
        
        return -1;
    }
    public int romanToInt(String s) {
        
        int res = 0;
        
        for(int i =0; i<s.length()-1; i++)
        {
            int num1 = FindNumber(s.charAt(i)); 
            int num2 = FindNumber(s.charAt(i+1));
            
             if(num1 >= num2)
                res += num1;
            
            else if(num2 > num1)
                res -= num1;
                
        }    
        return res + FindNumber(s.charAt(s.length()-1));
        
    }
    
}

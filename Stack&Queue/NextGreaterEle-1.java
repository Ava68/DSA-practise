class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<Character>();     
        st.push(s.charAt(0));
        
        for(int i =1; i<s.length(); i++)
        {
            char a = s.charAt(i);
            
            if(a == '(' || a == '[' || a == '{')
                st.push(a);
            
            else if( (a == '}' || a == ']' || a == ')' ) && st.isEmpty() )
                return false;
                
            else{
              boolean val =  validate(st.peek(),a);
                if(val)
                    st.pop();
                else
                    st.push(a);
            }
                
        }
        
        return st.isEmpty();
    }
    
    public boolean validate(char x,char y)
    {
        return (
            (x == '{' && y == '}' ) ||
            (x == '[' && y == ']') ||
            (x == '(' && y == ')')
         );
    }
}


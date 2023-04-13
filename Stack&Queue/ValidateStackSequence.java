https://leetcode.com/problems/validate-stack-sequences/description/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st = new Stack<Integer>();
        int cnt = 0;
        for(int i =0; i<pushed.length; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[cnt]){
                 st.pop();
                 cnt++;
            }
               
        }
        return st.isEmpty();
    }
}

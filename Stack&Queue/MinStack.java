https://leetcode.com/problems/min-stack/submissions/

class MinStack {

    Stack<Integer>st = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int val) {
        
      // pushing second last min and min value into stack.
        if(val <= min )
        {
            st.push(min);
            min = val;
        }
        
        st.push(val);
    }
    
    public void pop() {
        // removing 2 times
      // change current min to last min
        if(st.pop() == min)
        {
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

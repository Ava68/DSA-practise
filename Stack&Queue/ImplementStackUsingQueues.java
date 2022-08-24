https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    
    Queue<Integer> q1 = new LinkedList<Integer>();
    
    Queue<Integer> q2 = new LinkedList<Integer>();
    

    public MyStack() {
        
    }
    
    public void push(int x) {
        
        while(!q1.isEmpty())
            q2.add(q1.remove());
        
        
        q1.add(x);
        
        while(!q2.isEmpty())
            q1.add(q2.remove());
    }
    
    // we have made q1 such that it will push the latest element at start so if you remove it will act as stack
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

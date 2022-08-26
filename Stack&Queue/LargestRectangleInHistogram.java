https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/

Naive Approach

2 passes but o(n) soln

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // find left smaller array
        // find right smaller array
        int leftArr[] = new int[heights.length];
        int rightArr[] = new int[heights.length];
        
        leftArr[0] = 0;
        Stack<Integer>st1 = new Stack<Integer>();
        
        st1.push(0);
        
        for(int i =1; i<heights.length; i++)
        {
            while(!st1.isEmpty() && heights[st1.peek()] >= heights[i])
                st1.pop();
            
            int pd = st1.isEmpty() ? 0 : st1.peek()+1;
            leftArr[i] = pd;
            
            st1.push(i);
        }
        
        rightArr[heights.length-1] = heights.length-1;
        Stack<Integer>st2 = new Stack<Integer>();
        st2.push(heights.length-1);
        
        for(int i =heights.length-2; i>=0; i--)
        {
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[i])
                    st2.pop();
            int pd = st2.isEmpty() ? heights.length-1 : st2.peek()-1;
            
            rightArr[i] = pd;
            st2.push(i);
        }
        
        int maxArea = 0;
        
        for(int i =0; i<heights.length; i++)
        {
            int left = leftArr[i];
            int right = rightArr[i];
            
            maxArea = Math.max(maxArea, ((right - left ) +1) * heights[i]);
            
        }
        return maxArea;
    }
}

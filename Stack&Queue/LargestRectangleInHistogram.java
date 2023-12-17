class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nextSmallerEle [] = new int[n];
        Stack<Integer>st1 = new Stack<Integer>();  
        st1.add(n-1);
        nextSmallerEle[n-1] = n;
        for(int i =n-2; i>=0; i--)
        {
            while(!st1.isEmpty() && heights[st1.peek()] >= heights[i])
                st1.pop();
            int pd = st1.isEmpty() ? n : st1.peek();
            nextSmallerEle[i] = pd;
            st1.push(i);
        }
        int prevSmallerEle[] = new int[n];
        Stack<Integer> st2 = new Stack<Integer>();
        st2.add(0);
        prevSmallerEle[0] = -1;
        for(int i =1; i<n; i++)
        {
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[i])
                st2.pop();
            int pd = st2.isEmpty() ? -1 : st2.peek();
            prevSmallerEle[i] = pd;
            st2.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<n; i++)
        {
            maxArea = Math.max(maxArea,heights[i] * Math.abs( (nextSmallerEle[i] - prevSmallerEle[i]) - 1));
        }

        return maxArea;
    }
}

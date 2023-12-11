class Solution {
    public int trap(int[] height) {
         int leftMost[] = new int[height.length];
         leftMost[0] = -1;
         Stack<Integer>s1 = new Stack<Integer>();
         s1.push(height[0]);
         for(int i =1; i<height.length; i++)
        {
            while(!s1.isEmpty() && s1.peek() <= height[i])
                s1.pop();
            
            int pg = (s1.isEmpty()) ? - 1 : s1.peek();
            leftMost[i] = pg;
            if(pg == -1)
                s1.push(height[i]);   
        }
        int rightMost[] = new int[height.length];
        rightMost[height.length-1] = -1;
        Stack<Integer>s2 = new Stack<Integer>();
        s2.add(height[height.length-1]);
        for(int i =height.length-2; i>=0; i--)
        {
            while(!s2.isEmpty() && s2.peek() <= height[i])
                s2.pop();
            int pg = (s2.isEmpty()) ? - 1 : s2.peek();
            rightMost[i] = pg;
            if(pg == -1)
                s2.push(height[i]);
        }
        int ans = 0;
        for(int i =0; i<height.length; i++)
        {
            int leftMax = leftMost[i];
            int rightMax = rightMost[i];

            if(leftMax == -1 || rightMax == -1)
                continue;
            ans = ans + Math.min(leftMax,rightMax) - height[i];
        }
        return ans;
    } 
}

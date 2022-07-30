//    intuition is 
       
//        to find the rightmost greater building
//         then find the leftmost greater building
       
//        and then our formula is - > (leftmostbuilding - currentbuilding)
       
//        we need to check also there should be present atleast 1 right greater building and left greater
//        building to contain water at current building
// }

https://leetcode.com/problems/trapping-rain-water/submissions/

class Solution {
    public int trap(int[] height) {
        
        int water = 0;
        
        // leftMost Array
        ArrayList<Integer> leftMost = new ArrayList<Integer>();
        leftMost.add(-1);
        
        Stack<Integer>s1 = new Stack<Integer>();
        
        s1.push(height[0]);
        for(int i =1; i<height.length; i++)
        {

            while(!s1.isEmpty() && s1.peek() <= height[i])
                s1.pop();
            
            int pg = (s1.isEmpty()) ? - 1 : s1.peek();
            
            leftMost.add(pg);
            if(pg == -1)
                s1.push(height[i]);
          
        }
        
        // RightMost Array
        
        ArrayList<Integer> rightMost = new ArrayList<Integer>();
        rightMost.add(-1);
        
        Stack<Integer>s2 = new Stack<Integer>();
        
        s2.push(height[height.length-1]);
        
        for(int i =height.length-2; i>=0; i--)
        {

            while(!s2.isEmpty() && s2.peek() <= height[i])
                s2.pop();
            
            int pg = (s2.isEmpty()) ? - 1 : s2.peek();
            
            rightMost.add(pg);
            if(pg == -1)
                s2.push(height[i]);
        }
    
        
        
        for(int i = height.length - 2; i>=0; i--)
        {
         
            int left = leftMost.get(i);
            int right = rightMost.get( (height.length) - (i +1)); 
            
            System.out.println(left);
            
            if( left == -1 || right == -1)
                continue;
            
            else if(right >= left)
                water += left - height[i];
            
            else if(left> right)
                water += right - height[i];
        }
        
        return water;
        
    }
}
    



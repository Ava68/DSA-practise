https://leetcode.com/problems/sliding-window-maximum/

Brute Force solution

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
    ArrayList<Integer>res = new ArrayList<Integer>();
        
     
        
        for(int i =0; i<=nums.length-k; i++)
        {
            int max = Integer.MIN_VALUE;
            
            for(int j =i; j<i+k; j++)
                max = Math.max(max,nums[j]);
            
            res.add(max);
        }
        
        int ans[] = new int[res.size()];
        
        for(int i =0; i<res.size(); i++)
            ans[i] = res.get(i);
        
        return ans;
    }
}

optimal soln o(n)
  
  class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int [] res = new int[n-k+1];
        int ri = 0;
        
        Deque<Integer>q = new ArrayDeque<Integer>();
        
        for(int i =0; i<n; i++)
        {
            // remove numbers out of range
            
            while(!q.isEmpty() && q.peek() == i-k)
                q.poll();
            
            // remove smallest numbers in k range 
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            
            q.offer(i);
            
            if(i >= k-1)
                res[ri++] = nums[q.peek()];
        }
        
        return res;
    }
}

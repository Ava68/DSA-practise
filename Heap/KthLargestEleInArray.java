https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/


class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int a:nums)
            pq.offer(a);
        while(pq.size() > k)
        {
            pq.poll();
        }
        
        return pq.peek();
    }
}

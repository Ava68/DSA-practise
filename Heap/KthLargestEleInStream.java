https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/


class KthLargest {
     final PriorityQueue<Integer> q;
     final int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        
        for (int a :nums) {
            q.offer(a);
        }
        
        while(q.size() > k)
        {
            q.poll();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        
        if (q.size() > k) {
            System.out.println(q.peek());
            q.poll();
        }
        
        return q.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

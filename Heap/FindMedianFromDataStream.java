https://leetcode.com/problems/find-median-from-data-stream/discuss/1330646/C%2B%2BJavaPython-MinHeap-MaxHeap-Solution-Picture-explain-Clean-and-Concise

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
    }
    public void addNum(int num) {
        
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    public double findMedian() {
        
        if (maxHeap.size() > minHeap.size()) 
            return maxHeap.peek();
        
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

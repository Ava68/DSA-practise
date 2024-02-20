class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int val:stones) {
            pq.offer(val);
        }

        while(pq.size() >= 2) {
            int firstVal = pq.poll();
            int secondVal = pq.poll();

            if(firstVal != secondVal) {
                pq.add(Math.abs(firstVal - secondVal ));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}

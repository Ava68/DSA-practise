class pointsAndValue {
    int x;
    int y;
    int dist;

    pointsAndValue(int x, int y, int dist) 
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class pointsAndValueComparator implements Comparator<pointsAndValue> {

     @Override 
     public int compare(pointsAndValue p1, pointsAndValue p2) {
         return p1.dist - p2.dist;
     }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<pointsAndValue> pq = new PriorityQueue<pointsAndValue>(new pointsAndValueComparator());

        for(int point[] : points) {
            int value = point[0] * point[0] + point[1] * point[1];
            pq.offer(new pointsAndValue(point[0],point[1],value ));

         }

        int ans [][] = new int[k][2];
        int i =0;
         while(k > 0) {
             pointsAndValue poll = pq.poll();
             ans[i][0] = poll.x;
             ans[i++][1] = poll.y;
             k--;
         }
         return ans;
    }

}

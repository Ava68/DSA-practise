// similar implementation as minimum no to allocate pages

https://leetcode.com/problems/minimum-time-to-complete-trips/description/

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = 100000000000000L;
        while(left < right){
            long mid = (right - left)/2 + left;

            if(totalfun(time,totalTrips,mid)){
                right = mid;
            }
                
            else
                left = mid+1;
            
                
        }
        return left;

    }
    public boolean totalfun(int [] time,int totalTrips,long mid){
        
        long totalTime = 0;
        for(int i =0; i<time.length; i++){
            totalTime += mid/time[i];
        }

        return totalTime >= totalTrips;
    }
}

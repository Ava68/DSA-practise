https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low < high){
            int mid = (high - low)/2 + low;

            if(isPossible(piles,h,mid)){
                high = mid;
            }
            else
                low = mid+1;

        }
        return low;
    }
   public boolean isPossible(int[] piles,int h,int maxpiles){
       // simple math used
        int hours=0;
        for(int i:piles){
            int time=i/maxpiles;
            hours+=time;
            if(i%maxpiles!=0) hours++;
        }
        return hours <= h;
            
    }
}

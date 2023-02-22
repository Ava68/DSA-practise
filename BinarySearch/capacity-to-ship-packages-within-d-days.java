https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

This is same problem and slight variation of allocate min number of pages.

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        int res = 0;
         for(int i:weights)
        {
            low = Math.max(low,i);
            high += i;
        } 

        while(low <= high)
        {
            int mid = low+(high-low)/2;

            if(ispossible(weights,mid,days) == true)
            {
                res = mid;
                high  = mid-1;
            }
            else
                low = mid+1;
        }
        return res;   
    }
    public boolean ispossible(int[] weights, int mid,int days)
    {
        int sum = 0;
        int allocated = 1;
        for(int i =0; i<weights.length; i++)
        {
            if(sum + weights[i] > mid)
            {
                allocated++;
                sum = weights[i];
            }
            else
                sum += weights[i];
        }
        return (allocated <= days);
    }
}

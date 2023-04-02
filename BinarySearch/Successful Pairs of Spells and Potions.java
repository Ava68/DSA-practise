https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int ans[] = new int[spells.length];
        Arrays.sort(potions);
        for(int i =0; i<spells.length; i++){
             ans[i] = getPairCount(potions,spells[i],success);   
          
        }
        return ans;
    }

    public int getPairCount(int [] potions,int spell, long success)
    {
        int n = potions.length;
        int bestIdx = n;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            long product = (long)spell * potions[mid];

            if(product >= success)
            {
                bestIdx = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return (n - bestIdx);
    }
}

https://leetcode.com/problems/house-robber-ii/

Memoization solution
make your own tabulation 
class Solution {
    public int rob(int[] nums) {
        
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
         ArrayList<Integer> arr2 = new ArrayList<Integer>();
        
        for(int i =0; i<nums.length; i++)
        {
            if(i!=0)
                arr1.add(nums[i]);
            if(i!=nums.length-1)
                arr2.add(nums[i]);
        }
        if(nums.length==1)
                return nums[0];
         int dp1[] = new int[nums.length];
        int dp2 [] =  new int[nums.length];
        
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
       int exceptFirst = robhelper1(arr1.size()-1,arr1,dp1);
        int exceptLast =  robhelper2(arr2.size()-1,arr2,dp2);
        
       
        return Math.max(exceptFirst,exceptLast);
    }
    
    public int robhelper1(int indx,  ArrayList<Integer> arr1,int dp1[])
    {
        
        if(indx == 0)
            return arr1.get(0);
        
        
        if(indx < 0)
            return 0;
        if(dp1[indx] != -1)
            return dp1[indx];
        int pick = arr1.get(indx) + robhelper1(indx-2,arr1,dp1);
        int notPick = robhelper1(indx-1,arr1,dp1);
        
        return dp1[indx] = Math.max(pick,notPick);
        
    }
    
    public int robhelper2(int indx,  ArrayList<Integer> arr2, int dp2[])
    {
        
        if(indx == 0)
            return arr2.get(0);
        
        if(indx < 0)
            return 0;
        if(dp2[indx] != -1)
            return dp2[indx];
        int pick = arr2.get(indx) + robhelper2(indx-2,arr2,dp2);
        int notPick = robhelper2(indx-1,arr2,dp2);
        
        return dp2[indx] = Math.max(pick,notPick);
        
    }
}

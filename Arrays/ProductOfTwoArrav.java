// good example of prefix and suffix sum.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int preSum[] = new int[nums.length];
        int postSum[] = new int[nums.length];
        int ans [] = new int[nums.length];
        int adder = 1;
        for(int i =0; i<nums.length; i++)
        {
            preSum[i] = adder * nums[i]; 
            adder *= nums[i];
        }
        adder = 1;
        for(int j =nums.length-1; j>=0; j--)
        {
            postSum[j] = adder * nums[j]; 
            adder *= nums[j];
        }
        System.out.println(postSum[1]);
        for(int i =0; i<nums.length; i++)
        {
            if(i ==0)
                ans[i] = postSum[i+1];
            if(i == nums.length-1)
                ans[i] = preSum[i-1];
            if(i != 0 && i!= nums.length-1)
                ans[i] = preSum[i-1] * postSum[i+1];
        }

        return ans;
    }
}

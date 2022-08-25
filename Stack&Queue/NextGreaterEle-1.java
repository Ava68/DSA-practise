class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                
        Stack<Integer>st = new Stack<Integer>();
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        st.push(nums2[nums2.length-1]);
        map.put(nums2[nums2.length-1],-1);
        
        for(int i = nums2.length-2; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() < nums2[i])
                st.pop();
            
            int pd = st.isEmpty() ? -1 : st.peek();
            
            map.put(nums2[i] ,pd);
            
            st.push(nums2[i]);
        }
       
        int res[] = new int[nums1.length];
        
        for(int i = 0; i<nums1.length; i++)
        {
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}

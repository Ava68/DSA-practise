// based on next greater element
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Pair<Integer, Integer>> st = new Stack<>();
         int n = temperatures.length;
         st.push(new Pair<>(temperatures[n-1], n-1));
         int nge[] = new int[n];
         nge[n-1] = 0;

         for(int i=n-2; i>=0; i--)
         {
             while(!st.isEmpty() && st.peek().getKey() <= temperatures[i])
                st.pop();
            
            if(st.isEmpty())
                nge[i] = 0;
            else
                nge[i] = st.peek().getValue();
            st.push(new Pair<>(temperatures[i], i));
         }

        int ans [] = new int[n];

        for(int i =0; i<n; i++) 
        {
            if(nge[i] != 0)
                ans[i] = nge[i] - i;
            else
                ans[i] = 0;
        }

         return ans;
    }
}

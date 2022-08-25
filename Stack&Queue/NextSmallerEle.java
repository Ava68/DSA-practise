https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    int res[] = new int[arr.length];
	    
	    Stack<Integer>st = new Stack<Integer>();
	    st.push(arr[arr.length-1]);
	    res[n-1] = -1;
	    
	    
	    for(int i = arr.length-2; i>=0; i--)
	    {
	        while(!st.isEmpty() && st.peek() >= arr[i])
	            st.pop();
	       
	       int pd = st.isEmpty() ? -1: st.peek();
	       res[i] = pd;
	       
	       st.push(arr[i]);
	    }
	    
	    
	    return res;
	} 
}

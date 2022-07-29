https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1


optimal tc -> o(n)logn
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        
        int prefixSum = 0;
        int max = 0;
        
        for(int i =0; i<arr.length; i++)
        {
            prefixSum = prefixSum +arr[i];
            
            if(prefixSum == 0)
                max = i + 1;
            
            else
            {
                if(map.get(prefixSum) != null)
                {
                    max = Math.max(max, i - map.get(prefixSum));
                }
                
                else
                    map.put(prefixSum,i);
            }
        }
        
        return max;
        
       
       
        
        
    }
}

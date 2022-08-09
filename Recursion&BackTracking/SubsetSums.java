https://practice.geeksforgeeks.org/problems/subset-sums2234/1

// Intution is clear take or not take recursion problem

//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        subsetHelper(arr,0,res,0);
         
        return res;
    }
    
    public void subsetHelper(ArrayList<Integer>arr,int ind,ArrayList<Integer>res,int sum)
    {
        if(ind == arr.size())
        {
            res.add(sum);
            return;
        }
        
        sum += arr.get(ind);
        
        subsetHelper(arr,ind+1,res,sum);
        
        sum -= arr.get(ind);
        
        subsetHelper(arr,ind+1,res,sum);
    }
}

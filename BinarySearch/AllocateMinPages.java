Binary search soln

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int low = A[N-1];
        int high = 0;
        int res = -1;
        for(int i:A)
            high += i;
         
        while(low <= high)
        {
            int mid = low + high >> 1;
            
            if(allocationIsPossible(A,M,mid))
            {
                res = mid;
                high = mid-1;
            }
            
            else
                low = mid+1;
        }
        return res;
    }
    public static boolean allocationIsPossible(int A[],int M,int mid)
    {
        int allocStu = 1;
        int pages = 0;
        
        for(int i =0; i<A.length; i++)
        {
            if(pages + A[i] > mid)
            {
                allocStu++;
                pages = A[i];
            }
            else
                pages += A[i];
        }
        return (allocStu<=M);
    }
}

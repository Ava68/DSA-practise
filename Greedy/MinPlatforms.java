https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

// intutuion is 

// first sort the both arrival and dept time then point first pointer(i) at 1st index of arrival time
//and 2nd pointer at oth index of dept now compare if arrival time is lesser than or equal to departure time
// then so we need more platform otherwise and move the first pointer(i)
// else if arrival time is greater than departue it means 
// previous train has alreqady left so decrease the platform needed and increase the 2nd pointer(j).
// and take max of platform at every point of instance.

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
      // we will need atleast 1 platform for sure.
        int max = 1;
        int platform = 1;
      // we assumed that first train has already arrived so ith will start from 1 (not from 0)
        int i =1;
        int j =0;
        
        while(i<n && j<n)
        {
            if(arr[i] <= dep[j])
            {
                platform++;
                i++;
            }
            
            else if(arr[i] > dep[j] )
            {
                platform--;
                j++;
            }
            
            max = Math.max(max,platform);
        }
        
        return max;
    }
    
}

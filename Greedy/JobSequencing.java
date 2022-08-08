https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        
        int maxi =0;
        for(int i =0; i<n; i++)
        {
            maxi = Math.max(maxi,arr[i].deadline);
        }
        
        // creating deadline slots
        int result[] = new int[maxi+1];
        
        for(int i =1; i<=maxi; i++)
        {
            result[i] = -1;
        }
        
        int countjobs = 0;
        int profit = 0;
        
        for(int i =0; i<n; i++)
        {
            // checking for any slots from deadline to 0
            for(int j = arr[i].deadline; j>0; j--)
            {
                // free slot found (-1 is an empty day)
                if(result[j] == -1)
                {
                    result[j] = i;
                    countjobs++;
                    profit+= arr[i].profit;
                    break;
                }
            }
        }
        
        int ans[] = new int[2];
        ans[0] = countjobs;
        ans[1] = profit;
        
        return ans;
    }
}

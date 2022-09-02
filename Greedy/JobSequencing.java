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
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        int max= 0;
        
        for(int i =0; i<n; i++)
        {
            max = Math.max(max,arr[i].deadline);
        }
        
        int result[] = new int[max+1];
        
        for(int i =1; i<=max; i++)
        {
            result[i] = -1;
        }
        
        int profit = 0;
        int countjobs=0;
        for(int i =0; i<n; i++)
        {
         
            for(int ind=arr[i].deadline; ind>0; ind--)
            {
                if(result[ind] == -1)
                {
                    profit += arr[i].profit;
                    countjobs++;
                    result[ind] = arr[i].id; 
                    break;
                }
                
            }
        }
        int res [] = new int[2];
        res[0] = countjobs;
        res[1] = profit;
        
        return res;
    }
}

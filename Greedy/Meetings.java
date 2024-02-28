https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class Meeting
{
    int start;
    int end;
    int pos;
    
    Meeting(int start,int end , int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
        
    }
}

class meetingComparator implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting o1, Meeting o2)
    {
        if(o1.end < o2.end)
            return -1;
        else if(o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        
        ArrayList<Meeting>meet = new ArrayList<Meeting>();
        
        for(int i =0; i<start.length; i++)
            meet.add(new Meeting(start[i], end[i], i+1));
            
        meetingComparator mc = new meetingComparator();
        // sorting them in terms of end time
        Collections.sort(meet,mc);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(meet.get(0).pos);
        
        int endLimit = meet.get(0).end;
        
        for(int i =1; i<start.length; i++)
        {
            // checking start time of next meet is greater than theend time of previoius meeting
            if(meet.get(i).start > endLimit)
                {
                    endLimit = meet.get(i).end;
                    ans.add(meet.get(i).pos);
                }
        }
        
        return ans.size();
    }
}



// without using custom class

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        // Your code here  m
        int intervals[][] = new int [n][2];
        for(int i=0; i<start.length; i++)
        {
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }
        Arrays.sort(intervals,(a, b) -> a[1] - b[1] );
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int count = 1;
        for(int i=1; i<n; i++)
        {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            
            // overlapping condition
            if(newStart <= prevEnd)
            {
                continue;
            }
            else 
            {
                prevStart = newStart;
                prevEnd = newEnd;
                count++;
            }
        }
        return count;
    
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        List<int[]> al = new ArrayList<>();
        for(int i =0; i<intervals.length; i++)
            System.out.println(intervals[i][0] + "," +intervals[i][1]);

        al.add(new int[]{intervals[0][0], intervals[0][1] });
        int ans = 0;
        for(int i =1; i<intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int latestList [] = al.get(al.size()-1);
            int prev_start = latestList[0];
            int prev_end = latestList[1];

            if(start < prev_end)
            {
                ans++;
                continue;
            }
            else
                al.add(new int[]{start,end});
        }
        return ans;
    }
}

/*
my looking into this I have 2 thoughts

    1) sort the array ( with end intervals)
    2) once u have the sorted array 
    3) intitially push first index into some sort of arraylist
    4) each iteration we have to check non-overlapping with the last arraylist if it is non overlapping just increment the count push min(start) and max(end)
    5) if it's not an overlapping array just add in arrlist
    6) return count;

*/

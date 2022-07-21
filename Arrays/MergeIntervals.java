https://leetcode.com/problems/merge-intervals/submissions/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]>res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null)
                return res.toArray(new int[0][]);
        
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i[] :intervals)
        {
            if(end >= i[0])
            {
                end = Math.max(end,i[1]);
            }
            
            else{
                int sub [] = new int[2];
                sub[0] = start;
                sub[1] = end;
                res.add(sub);
                
                start = i[0];
                end = i[1];
            }
        }
        
        int lastvals[] = new int[2];
        lastvals[0] = start;
        lastvals[1]  = end;
        
        res.add(lastvals);
        
        return res.toArray(new int[0][]);
    }
}

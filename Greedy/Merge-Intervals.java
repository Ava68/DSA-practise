class Solution {
    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        al.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i =1; i<intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int latestList[] = al.get(al.size()-1);

            if(start <= latestList[1])
            {
                al.remove(al.get(al.size()-1));
                al.add(new int[]{Math.min(start,latestList[0]), Math.max(end,latestList[1])});
            }
            else {
                al.add(new int[]{start,end});
            }
        }
        int[][] result = new int[al.size()][];
        for (int i = 0; i < al.size(); i++) {
            result[i] = al.get(i);
        }

    return result;
    }
}

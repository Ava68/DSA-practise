https://leetcode.com/problems/course-schedule/submissions/
bfs kahns algo

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        
        int indegree[] = new int[n];
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int p[]: prerequisites )
        {
            adj.get(p[1]).add(p[0]);
        }
        
        for(int i =0; i<n ; i++)
        {
            for(int it:adj.get(i))
                indegree[it]++;
        }
        
        Queue<Integer>q = new LinkedList<Integer>();
        
        for(int i =0; i<n; i++)
        {
            if(indegree[i] == 0)
                q.offer(i);
        }
        
        int cnt = 0;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            cnt++;
            
            for(int it: adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        
        if(cnt != n)
            return false;
        return true;
        
    }
}

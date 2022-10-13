https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class Pair implements Comparator<Pair>
{
    int v;
    int weight;
    
    Pair(int v,int weight)
    {
        this.v = v;
        this.weight = weight;
    }
    Pair() {} 
    @Override 
    public int compare(Pair n1,Pair n2)
    {
        return n1.weight - n2.weight;
    }
    
    
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>(V, new Pair());
        dist[S] = 0;
        pq.add(new Pair(S,0));
        
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            
            for(ArrayList<Integer> node: adj.get(curr.v))
            {
                if(dist[curr.v] + node.get(1) < dist[node.get(0)] )
                {
                  dist[node.get(0)] =  dist[curr.v] + node.get(1) ;
                  pq.add(new Pair(node.get(0), dist[node.get(0)] ));
                  
                }
            }
        }
        return dist;
    }
}

https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

class Pair implements Comparator<Pair>{
    int v;
    int weight;
    
    Pair(int v, int weight)
    {
        this.v = v;
        this.weight = weight;
    }
    Pair() {} 
    @Override  
    public int compare(Pair a, Pair b) {  
        return a.weight - b.weight;
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>(V, new Pair());
        
        int key[] = new int[V];
        boolean mst[] = new boolean[V];
        
        for(int i =0; i<V; i++)
        {
            mst[i] = false;
            key[i] =  Integer.MAX_VALUE;
            
        }
        
        pq.add(new Pair(0,0));
        key[0] = 0;
        
        // ArrayList<ArrayList<ArrayList<Integer>>> adj this is the declaration of our graph
      
        while(!pq.isEmpty())
        {
            Pair u = pq.poll();
            mst[u.v] = true;
            
             for(ArrayList<Integer> node : adj.get(u.v))
            {
                if(mst[node.get(0)] == false && node.get(1) < key[node.get(0)])
                {
                     key[node.get(0)] = node.get(1);
                     pq.add(new Pair(node.get(0) , key[node.get(0)] ));
                }
                   
            }
        }
        
        int cost = 0;
        for(int i =0; i<V; i++)
            cost+= key[i];
    return cost;
        
    }
}

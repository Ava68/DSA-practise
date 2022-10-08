
https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/

to create shortest path in dag weighted graph

we need to make it topological sorting first

class Pair
{
  private int v;
  private int weight;
  
  Pair(int v, int weight)
  {
    this.v = v;
    this.weight = weight;
  }
  
  int getV(){ return v;}
  int getWeight() { return weight; }
  
}

void topoLogicalSort(int node, boolean visited[], stack<Integer> st, ArrayList<ArrayList<Pair>>adj)
{
  visited[node] = true;
  
  for(Pair it: adj.get(node))
  {
    if(visited[it.getV()] == false)
      topoLogicalSort(it.getV(), visited,st,adj);
  }
 
  st.push(node);
}

void shortestPath(int src, ArrayList<ArrayList<Pair>> adj,int N)
{
    Stack<Integer>st = new Stack<Integer>();
  
    boolean visited[] = new boolen[N];
    Arrays.fill(visited,false);
    
    for(int i =0; i<N; i++)
    {
      if(visited[i] == false)
        topoLogicalSort(i,visited,st,adj)
    }
  
  int dist[] = new int[N];
  Arrays.fill(dist,Integer.MAX_VALUE);
  
  dist[src] = 0;
  
  while(!st.isEmpty())
  {
    int node = st.pop();
    
    if(dist[node] != Integer.MAX_VALUE)
    {
      for(Pair it : adj.get(node))
      {
        if(dist[node] + it.getWeight() < dist[it.getV()] )
          dist[it.getV()] = dist[node] + it.getWeight();
      }
      
    }
    
  }
  
  for(int i =0; i<N; i++)
  {
      if(dist[i] == Integer.MAX_VALUE;
         System.out.println("INFINTE");
       else
          System.out.println(dist[i]);
    
  }
  
}

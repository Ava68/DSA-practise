https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> boundary = new ArrayList<Integer>();
	    if(node == null)
	        return boundary;
	    if(isLeaf(node) == false)
	       boundary.add(node.data);
	   
	   addLeftBoundary(node,boundary);
	   addLeaves(node,boundary);
	   addRightBoundary(node,boundary);
	   
	   return boundary;
	    
	}
	
	public boolean isLeaf(Node node)
	{
	     return (node.left == null && node.right == null);
	}
	   
	    
	public void addLeftBoundary(Node node,ArrayList<Integer>boundary)
	{
	    node = node.left;
	    
	    while(node != null)
	    {
	        if(isLeaf(node) == false)
	            boundary.add(node.data);
	       if(node.left != null)
	            node = node.left;
	       else
	        node = node.right;
	    }
	}
	
	public void addLeaves(Node node,ArrayList<Integer> boundary)
	{
	    if(node.left == null && node.right == null)
	    {
	        boundary.add(node.data);
	        return;
	    }
	    if(node.left != null)
	        addLeaves(node.left,boundary);
	        
	    if(node.right != null)
	        addLeaves(node.right,boundary);
	}
	
	public void addRightBoundary(Node node, ArrayList<Integer> boundary)
	{
	     node = node.right;
	    Stack<Integer>st = new Stack<Integer>();
	    
	    while(node != null)
	    {
	        if(isLeaf(node) == false)
	            st.push(node.data);
	       
	        if(node.right != null)
	            node = node.right;
	       else
	         node = node.left;
	    }
	    
	    while(!st.isEmpty())
	        boundary.add(st.pop());
	}
}

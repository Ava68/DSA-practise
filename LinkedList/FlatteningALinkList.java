// funda is clear to use merge technique of merge sort here
class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	
	    if(root == null || root.next == null)
	        return root;
	        
	   root.next = flatten(root.next);
	   root = mergeTwoList(root,root.next);
	   
	   return root;
	
    }
    
    Node mergeTwoList(Node a , Node b)
    {
        Node temp = new Node(0);
        Node res = temp;
        
        while(a != null && b != null)
        {
            if(a.data < b.data)
            {
                temp.bottom = a;
                a = a.bottom;
                temp = temp.bottom;
                
            }
            else{
                temp.bottom = b;
                b = b.bottom;
                temp = temp.bottom;
            }
        }
        
        if(a != null)
            temp.bottom = a;
        else
            temp.bottom = b;
            
    return res.bottom;
    }
}

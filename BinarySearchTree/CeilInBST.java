https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        Node curr = root;
        
        int ceil = -1;
        while(curr != null )
        {
            
            if(curr.data == key)
                {
                    ceil = curr.data;
                    break;
                }
                
            if(curr.data > key)
            {
                ceil = curr.data;
                curr = curr.left;
            }
                
            else
                curr = curr.right;
        }
        
        return ceil;
    }
}

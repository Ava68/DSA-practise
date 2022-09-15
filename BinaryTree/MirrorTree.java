
https://practice.geeksforgeeks.org/problems/mirror-tree/1


class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node root) {
        // Your code here
        if(root == null)
            return;
        
        Node temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        mirror(root.left);
        mirror(root.right);
        
        
        
        
    }
}

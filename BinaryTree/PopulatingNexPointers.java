

DfS Soln

public void connect(TreeLinkNode root) {
    if(root == null)
        return;
        
    if(root.left != null){
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
    }
    
    connect(root.left);
    connect(root.right);
}


BFS

class Pair{
    int nextNull;
    Node root;
    Pair(int nextNull, Node root)
    {
        this.nextNull = nextNull;
        
        this.root = root;
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(1,root));
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            Node node = p.root;
            int nextNull = p.nextNull;
            
            
            if(nextNull == 1)
            {
                node.next = null;
                
                if(node.left != null)
                    q.add(new Pair(0,node.left));
                    
                if(node.right != null)
                    q.add(new Pair(1,node.right));
            }
            
            else
            {
                System.out.println(q.peek().root.val);
                node.next = q.peek().root;
                    
                if(node.left != null)
                    q.add(new Pair(0,node.left));
                    
                if(node.right != null)
                    q.add(new Pair(0,node.right));
            }
                
            
            
        }
        
        return root;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer>sub = new ArrayList<Integer>();
            
            for(int i =0; i<size; i++)
            {
                TreeNode p = q.poll();
                
                if(p.left != null)
                    q.offer(p.left);
                if(p.right != null)
                    q.offer(p.right);
                
                if(flag == true)
                {
                    sub.add(p.val);
                }
                else
                    sub.add(0,p.val);
            }
            
            flag = !flag;
            
            ans.add(sub);
        }
        
        return ans;
    }
}

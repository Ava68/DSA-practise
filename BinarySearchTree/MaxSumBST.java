Brute force soln
o(n) ^ 2
  
class Solution {
    
    int maxsum = 0;
    public int maxSumBST(TreeNode root) {
       if(root == null)
           return 0;
        
       if(isValidBST(root))
           maxsum = Math.max(maxsum,sumTree(root));
        
        maxSumBST(root.left);
        maxSumBST(root.right);
        
        return maxsum;
    }
    
    public boolean isValidBST(TreeNode root)
    {
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
        
    public boolean isBST(TreeNode root,int minRange,int maxRange)
    {
        if(root == null) return true;

        if(root.val <= minRange || root.val >= maxRange) return false;

        return isBST(root.left, minRange, root.val) &&                                    isBST(root.right, root.val, maxRange);
    }
    
    public int sumTree(TreeNode root)
    {
        if(root == null)
            return 0;
        
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
    
}


optimal soln

class Solution {
    int maxSum = 0;  //maxSum initialized to maintain it at every step and made global so no need to pass in function
    class NodePair{ /// this class will be viewed as a single node of tree
        int min, max, sum;
    }
    public NodePair getSum(TreeNode root){
        if(root == null){  // if null then return sum 0 and minimum value as Int max and max value as Int min
            NodePair a = new NodePair();
            a.min = Integer.MAX_VALUE;
            a.max = Integer.MIN_VALUE;
            a.sum = 0;
            return a;
        }
        NodePair main = new NodePair();
        NodePair left = getSum(root.left);  //recursion till leftmost node
        NodePair right = getSum(root.right);  //recursion till rightmost node
        
        if(left.max < root.val && root.val < right.min){  //validating the bst
            main.min = Math.min(root.val, Math.min(left.min, right.min));
            main.max = Math.max(root.val, Math.max(left.max, right.max));
            main.sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum,main.sum);
        }
        else{
            main.min = Integer.MIN_VALUE;  // if not bst then just pass the sum calculated as of now
            main.max = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum,right.sum);
        }
        return main;
    }
    public int maxSumBST(TreeNode root) {
        NodePair temp = new NodePair();
        temp = getSum(root);
        return maxSum > 0 ? maxSum : 0;
    }
}

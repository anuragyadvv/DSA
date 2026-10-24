/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // we will check condition for non identical 
        // if(p==null && q==null){
        //     return true;
        // }
        // else if(p==null || q==null){
        //     return false;
        // }
        //  if(p.val!=q.val){
        //     return false;
        // }
        // if(!isSameTree(p.left,q.left)){
        //     return false;
        // }

        // if(!isSameTree(p.right,q.right)){
        //     return false;
        // }
        // // if none of the non identical condition are true  then it is identical then in that case return true
        // return true;
         
        //  or 
        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


        // Approach -2 (using BFS )

        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1 = q1.remove();
            TreeNode node2 = q2.remove();

            if(node1.val != node2.val){
                return false;
            }

            if(node1.left != null  && node2.left !=null){
                q1.add(node1.left);
                q2.add(node2.left);
            }
            else if(node1.left!= null || node2.left != null){
                return false;
            }

              if(node1.right != null  && node2.right !=null){
                q1.add(node1.right);
                q2.add(node2.right);
            }
            else if(node1.right!= null || node2.right != null){
                return false;
            }
        }

        return true;
    }
}
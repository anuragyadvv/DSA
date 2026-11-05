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
    public int minDepth(TreeNode root) {
        // if(root==null){
        //     return 0;
        // }

        // if(root.left==null && root.right==null){
        //     return 1 ;
        // }
        // int left = root.left != null? minDepth(root.left): Integer.MAX_VALUE;
        // int right= root.right != null ? minDepth(root.right):Integer.MAX_VALUE;
        
   
       
        // return Math.min(left,)+1;


        // Approach - 2(using BFS )

        if(root==null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int depth = 1;

        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            
            // traversing the current level 
            while(n-->0){
                TreeNode node = q.remove();

                if(node.left==null && node.right == null){
                    return depth;
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            depth++;
        }

        return -1;
        
    }
}
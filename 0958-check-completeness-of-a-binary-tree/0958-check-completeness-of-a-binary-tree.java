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
    public boolean isCompleteTree(TreeNode root) {
         boolean seenPast = false;
         Queue<TreeNode> q = new LinkedList<>();

         q.add(root);

         while(!q.isEmpty()){

            TreeNode node = q.remove();

            if(node !=null){
                if(seenPast==true){
                    return false;
                }
            }
            if(node ==null){
                seenPast = true;
                continue;
            }

            q.add(node.left);
            q.add(node.right);

         }

         return true;
        
    }
}
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
    public List<Integer> inorderTraversal(TreeNode root) {

        // Approach - 2 (using Morris Traversal)

        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){ // L,V,R
                result.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode leftChild = curr.left ;
            //    curr ke left child ke rightmost node pe chle jaao 
             while(leftChild.right != null){
                leftChild = leftChild.right;
             }

             leftChild.right = curr;
            //  curr.left ko hum null mark kr sakte hai 
            TreeNode temp = curr;
            curr = curr.left;
            temp.left = null;

            }
        }

        return result;
        
    }
}
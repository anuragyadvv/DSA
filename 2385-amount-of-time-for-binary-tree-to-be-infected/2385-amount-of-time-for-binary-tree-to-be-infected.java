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
    int result = Integer.MIN_VALUE;
    public int amountOfTime(TreeNode root, int start) {

        // Approach - 3 (using DFS  done with BFS already)

      solve(root, start);

      return result;
        
    }

    private int solve(TreeNode root, int start){
        if(root == null) return 0;

        int leftHeight = solve(root.left, start);
        int rightHeight = solve(root.right, start);

        if(root.val == start){
            result = Math.max(leftHeight, rightHeight);
            return -1;
        }
        
        else if(leftHeight >=0 && rightHeight >=0){
            return Math.max(leftHeight,rightHeight)+1;
        }
        else{
            int d = Math.abs(leftHeight)+Math.abs(rightHeight);
            result = Math.max(result, d);
            return Math.min(leftHeight,rightHeight) -1;
        }
    }
}
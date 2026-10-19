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
    public int maxAncestorDiff(TreeNode root) {

        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;

        return solve(root, maxV, minV);
        
    }

    public int solve(TreeNode root, int maxV, int minV){

        if(root==null){ //as we go after leaf node
            return Math.abs(maxV-minV);
        }

        maxV = Math.max(maxV,root.val);
        minV = Math.min(minV, root.val);

        int left = solve(root.left,maxV,minV);
        int right = solve(root.right,maxV, minV);

        return Math.max(left,right);
    }
}
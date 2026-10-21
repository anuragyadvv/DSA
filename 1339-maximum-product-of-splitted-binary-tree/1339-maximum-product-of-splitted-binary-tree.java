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
    long SUM =0; // totalSum of tree 
    long maxProd ;
    public int maxProduct(TreeNode root) {

        maxProd =0;

        if(root==null) return 0;

        SUM = totalSum(root);

        find(root);

        return (int)( maxProd %1000000007);

        
    }

    public int totalSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSubTreeSum = totalSum(root.left);
        int rightSubTreeSum = totalSum(root.right);
        int sum = root.val + leftSubTreeSum + rightSubTreeSum;

        return sum;

         
    }

    public int find(TreeNode root){
        if(root==null) return 0;

        int leftSum = find(root.left);
        int rightSum = find(root.right);
        long subTreeSum = root.val + leftSum + rightSum;  // S1

        long remainingSubTreeSum = SUM - subTreeSum; // S2
        maxProd = Math.max(maxProd , (subTreeSum*remainingSubTreeSum));

        return (int) subTreeSum;

    }
}
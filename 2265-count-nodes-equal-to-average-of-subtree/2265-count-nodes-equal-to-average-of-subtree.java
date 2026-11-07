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

    int totalCount  ;
    public int averageOfSubtree(TreeNode root) {

        totalCount = 0;

         solve(root);

        return totalCount;
    }

    public void solve(TreeNode root){

        if(root==null) return ;

        int sum = findSum(root);
        int count = findCount(root);
    

        if((sum/count)==root.val) totalCount++;

        solve(root.left);
        solve(root.right);
    }

    public int findSum(TreeNode root){
         
         if(root==null){
            return 0;
         }

         int leftSum = findSum(root.left);
         int rightSum = findSum(root.right);

         return leftSum + rightSum + root.val;
    }

    public int findCount(TreeNode root){

        if(root==null) return 0;

        int leftCount = findCount(root.left);
        int rightCount = findCount(root.right);

        return leftCount + rightCount+1;
    }
}
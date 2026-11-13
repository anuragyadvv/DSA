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
//     Approach -2 (using bit manipulation)
    int count ;
    public int pseudoPalindromicPaths (TreeNode root) {

        count =0;
        

        solve(root, 0);

        return count;

        
    }

    public void solve(TreeNode root, int val){

        if(root==null){
            return ;
        }

        val = (val^(1<<root.val));

        if(root.left==null && root.right == null){ // leaf node 
          
          if((val & (val-1)) == 0){  // checking only one set bit is present that means it is power of 2 
            count++;
          }
        }

        solve(root.left,val);
        solve(root.right,val);

       
    }
}
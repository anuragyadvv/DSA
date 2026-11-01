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
    int maxPath = 0;
    public int longestZigZag(TreeNode root) {
        
        //  we will try both the possibility of left and right 
        solve(root, 0, true, false); // goLeft
        solve(root, 0, false, true); // goRight


        return maxPath;


        
    }

    private void solve(TreeNode root, int steps, boolean goLeft, boolean goRight){

        if(root==null) return ;

        maxPath = Math.max(maxPath, steps);

        if(goLeft==true){
            solve(root.left,steps+1,false,true); // now go right 
            solve(root.right, 1, true, false); // new path starts so next time go left because taken right this time 
        }else if(goRight==true){
            solve(root.right, steps+1, true, false); // now goLeft
            solve(root.left, 1, false, true);  // new path starts so next time go right because taken left this time 
        }

    }
}
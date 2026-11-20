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
    String result ="";
    public String smallestFromLeaf(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        solve(root, sb);

        return result;
        
    }

    public void solve(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }

        sb.append((char)('a' + root.val));



        if(root.left == null && root.right == null){

            sb.reverse(); // reverse it so it becom leaf to root path 
            if(result.length()==0){
                result = sb.toString();
            }else{
                if(result.compareTo(sb.toString())>0){
                    result = sb.toString();
                }
            }

            sb.reverse(); // Restore root-to-leaf order for backtracking!
        }
        

        solve(root.left, sb);
        solve(root.right,sb);

        sb.deleteCharAt(sb.length()-1);
    }
}
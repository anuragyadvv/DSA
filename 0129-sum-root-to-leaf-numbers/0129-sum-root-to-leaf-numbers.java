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
    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(root, list, sb);

        int ans = 0;
        for(String str : list){
            ans += Integer.parseInt(str);
        }

        return ans;
        
    }

    public void solve(TreeNode root, List<String> list , StringBuilder sb){

        if(root==null){
            return;
        }

        sb.append(root.val);

        if(root.left ==null && root.right ==null){
            list.add(sb.toString());
           
        }

        solve(root.left, list, sb);
        solve(root.right, list, sb);

        sb.deleteCharAt(sb.length()-1);

        
    }
}
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        solve(root, result, map);

        return result;
        
    }

    public String solve(TreeNode root, List<TreeNode>result, Map<String,Integer> map){

        if(root==null){
            return "NULL";
        }

        String s = Integer.toString(root.val) + "," + solve(root.left, result, map)+ "," + solve(root.right,result,map);

        if(map.getOrDefault(s,0)==1){
            result.add(root);
        }

        map.put(s, map.getOrDefault(s,0)+1);

        return s;
    }
}
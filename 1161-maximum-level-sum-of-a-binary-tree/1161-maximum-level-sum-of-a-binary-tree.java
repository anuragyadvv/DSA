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
    public int maxLevelSum(TreeNode root) {

        // Approach - 2(using dfs )
         TreeMap<Integer, Integer> map = new TreeMap<>();

         dfs(root, 1, map);

         int maxLevel = 0;
         int maxSum =Integer.MIN_VALUE;

         for(Integer key : map.keySet()){
             if(maxSum< map.get(key)){
                maxSum = map.get(key);
                maxLevel = key;
             }
         }

         return maxLevel;
        
    }

    public void dfs(TreeNode root, int level, TreeMap<Integer,Integer> map){

        if(root==null){
            return;
        }

        map.put(level, map.getOrDefault(level,0)+root.val);

        dfs(root.left,level+1,map);
        dfs(root.right,level+1, map);
    }
}
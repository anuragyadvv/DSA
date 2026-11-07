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
    public List<Integer> largestValues(TreeNode root) {

        // approach - Level order traversal 
        List<Integer> result = new ArrayList<>();

           if(root==null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int n = q.size();

            int maxValue = Integer.MIN_VALUE;

            while(n-->0){

                TreeNode node = q.remove();
                maxValue = Math.max(maxValue,node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }

            }

            result.add(maxValue);
        }


        return result;
        
    }
}
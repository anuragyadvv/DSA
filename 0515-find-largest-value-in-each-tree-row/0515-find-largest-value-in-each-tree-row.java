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

        // approach 1 - Level order traversal (standard blueprint of BFS)
        // List<Integer> result = new ArrayList<>();

        //    if(root==null){
        //     return result;
        // }

        // Queue<TreeNode> q = new LinkedList<>();

        // q.add(root);

        // while(!q.isEmpty()){

        //     int n = q.size();

        //     int maxValue = Integer.MIN_VALUE;

        //     while(n-->0){

        //         TreeNode node = q.remove();
        //         maxValue = Math.max(maxValue,node.val);

        //         if(node.left != null){
        //             q.add(node.left);
        //         }

        //         if(node.right != null){
        //             q.add(node.right);
        //         }

        //     }

        //     result.add(maxValue);
        // }


        // return result;


        // Approach -2 (DFS )(pattern)(This technique is used in some other popular tree problem )

        List<Integer> result = new ArrayList<>();

        DFS(root, 0, result);

        return result;
        
    }

    public void DFS(TreeNode root, int depth, List<Integer> result){

        if(root== null){
            return;
        }
        if(result.size()==depth){ // mean at this depth we are coming for the first time 
            result.add(root.val);
        }
        else{ // means we have already been to this depth
          result.set(depth, Math.max(result.get(depth),root.val));
        }

        DFS(root.left, depth+1, result);
        DFS(root.right, depth+1, result);
    }
}
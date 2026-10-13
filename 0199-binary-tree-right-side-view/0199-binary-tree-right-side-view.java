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
    public List<Integer> rightSideView(TreeNode root) {

        // Approach -1 (level order traversal)

        // List<Integer> result = new ArrayList<>();

        // if(root==null){
        //     return result;
        // }
        
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()){
        //     int n = q.size();
            
        //     TreeNode node = null;
        //     for(int i=0;i<n;i++){
        //       node = q.remove();

        //       if(node.left !=null){
        //         q.add(node.left);
        //       }  

        //       if(node.right != null){
        //         q.add(node. right);
        //       }
        //     }

        //     result.add(node.val);
        // }

       

        // return result;


        // Approach -2(DFS)

        List<Integer> result = new ArrayList<>();

        solve(root, result,1);

        return result; 
    }

    public void solve(TreeNode root,List<Integer> result, int level ){

        if(root==null){
            return;
        }

        if(result.size()< level){
            result.add(root.val);
        }

        solve(root.right, result,level+1);
        solve(root.left, result, level+1);
    }
}
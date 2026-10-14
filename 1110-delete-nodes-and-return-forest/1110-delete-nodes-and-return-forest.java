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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int num : to_delete){
            set.add(num);
        }

        deleteHelper(root, set, result);

        if(!set.contains(root.val)){ // then add it in result 

          result.add(root);

        }

        return result;
        
    }

    public TreeNode deleteHelper(TreeNode root, Set<Integer> set,  List<TreeNode> result){

        if(root==null){
            return null;
        }

        root.left = deleteHelper(root.left, set, result);
        root.right = deleteHelper(root.right, set, result);

        if(set.contains(root.val)){

            // store left and right child of the node that is to be deleted and store it in  the result 
           if(root.left != null){
            result.add(root.left);
           }

           if(root.right != null){
            result.add(root.right);
           }

           return null;  // deleted the node and returned null 
        }

        else{ // if not to be deleted 
            return root;
        }
    }
}
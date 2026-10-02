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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root==null){
            return result;
        }
        
        q.add(root);
        boolean flag = false; // means false = left to right and true = right to left 

        while(!q.isEmpty()){

            int size = q.size();
            Integer arr[] = new Integer[size]; // to store current level element at last we will convert it to list and at each level a new arr will be generated

            for(int i=0;i<size;i++){

                TreeNode node = q.remove();

                int idx = (flag==false)? i : size-1-i;

                arr[idx] = node.val;

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            flag = ! flag; // after each level flag will be reversed 
            result.add(Arrays.asList(arr)); // conver arr array to list and add it to result after each level 
        }

        return result;
          
    }
}
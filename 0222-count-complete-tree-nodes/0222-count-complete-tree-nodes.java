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
    public int countNodes(TreeNode root) {
        // if(root==null){
        //     return 0;
        // }
        // int leftCount=countNodes(root.left);
        // int rightCount=countNodes(root.right);
        // return leftCount+rightCount+1;
        
        // Approach-2 (less than O(n) complexity)

        if(root==null){
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if(lh==rh){ // perfect binary tree 
        return (int)(Math.pow(2,lh)-1);

        }

        return countNodes(root.left)+countNodes(root.right)+1;
    }

    public int getLeftHeight(TreeNode root){
        TreeNode temp = root;
        int lh =0;
        while(temp != null){
            temp = temp.left;
            lh++;
        }

        return lh;
    }


        public int getRightHeight(TreeNode root){
        TreeNode temp = root;
        int rh =0;
        while(temp != null){
            temp = temp.right;
            rh++;
        }

        return rh;
    }
}
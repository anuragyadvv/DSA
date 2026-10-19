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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        int currDepth = 1;
        return solve(root, val, depth, currDepth);

    }

    public TreeNode solve(TreeNode root, int val, int depth, int currDepth) {

        if (root == null) {
            return null;
        }
        if (currDepth == depth - 1) {
            TreeNode leftTemp = root.left;

            TreeNode rightTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            if (leftTemp != null) {
                root.left.left = leftTemp;
            }

            if (rightTemp != null) {
                root.right.right = rightTemp;
            }

            return root;
        } else {
            solve(root.left, val, depth, currDepth + 1);
            solve(root.right, val, depth, currDepth + 1);
        }

        return root;

    }
}
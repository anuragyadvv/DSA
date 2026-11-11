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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>(); // store every node's parent 
        inorder(root, map);

        // Find the actual start TreeNode in the tree instead of creating a new object
        TreeNode startNode = findStartNode(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(startNode);
        visited.add(startNode);

        int minutes = 0;

        while (!q.isEmpty()) {

            int n = q.size();

            while (n-- > 0) {
                TreeNode curr = q.poll();
                
                // parent 
                if (map.get(curr) != null && !visited.contains(map.get(curr))) {
                    q.offer(map.get(curr));
                    visited.add(map.get(curr));
                }

                // left child 
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

            }

            minutes++;
        }

        return minutes - 1;
        
    }

    public void inorder(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;

        if (root.left != null) {
            map.put(root.left, root);
            inorder(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right, root);
            inorder(root.right, map);
        }
    }

    // Added helper to locate the real start node object
    public TreeNode findStartNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = findStartNode(root.left, start);

        TreeNode right = findStartNode(root.right, start);

        return left != null ? left : right;
        

        
    }
}
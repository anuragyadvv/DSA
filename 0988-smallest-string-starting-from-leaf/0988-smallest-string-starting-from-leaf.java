class Solution {

    // Approach -2 (using BFS) done with DFS 
    // Custom Pair class to hold the node and its leaf-to-root path string
    static class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = "";
        Queue<Pair> q = new LinkedList<>();
        
        // Start with the root character
        q.add(new Pair(root, String.valueOf((char) ('a' + root.val))));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            String path = curr.path;

            // If it's a leaf node, compare with the smallest string found so far
            if (node.left == null && node.right == null) {
                if (result.isEmpty() || result.compareTo(path) > 0) {
                    result = path;
                }
            }

            // Prepend the child's character so the string stays in leaf-to-root order
            if (node.left != null) {
                q.add(new Pair(node.left, (char) ('a' + node.left.val) + path));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, (char) ('a' + node.right.val) + path));
            }
        }

        return result;
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxLevel = 1;
        long maxSum = Long.MIN_VALUE; // Handles negative node values properly
        int currentLevel = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            long currentLevelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currentLevelSum += curr.val;

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Update max sum and level. 
            // Using strict inequality (>) ensures that in case of a tie, 
            // the *smallest* level number is kept because we visit levels top-down.
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
    }
}
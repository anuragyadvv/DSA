import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0, n, costs, memo); // Removed currCost parameter
    }

    public int solve(int i, int n, int[] costs, int memo[]) {
        if (i == n) {
            return 0; // Base case: 0 extra cost needed from the top
        }
        if (i > n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i] != -1) {
            return memo[i]; // Safe to memoize remaining cost from i
        }

        // Add the cost of the landing step + jump penalty squared + future cost
        int cost1 = (i + 1 <= n) ? costs[i] + (1 * 1) + solve(i + 1, n, costs, memo) : Integer.MAX_VALUE;
        int cost2 = (i + 2 <= n) ? costs[i + 1] + (2 * 2) + solve(i + 2, n, costs, memo) : Integer.MAX_VALUE;
        int cost3 = (i + 3 <= n) ? costs[i + 2] + (3 * 3) + solve(i + 3, n, costs, memo) : Integer.MAX_VALUE;

        if (cost1 == Integer.MAX_VALUE && cost2 == Integer.MAX_VALUE && cost3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        memo[i] = Math.min(cost1, Math.min(cost2, cost3));

        return memo[i];
    }
}
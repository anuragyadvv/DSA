class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // 3D Boolean memo table (null means unvisited)
        Boolean[][][] memo = new Boolean[m][n][m + n + 1];

        return solve(grid, 0, 0, 0, m, n, memo);
    }

    public boolean solve(char[][] grid, int i, int j, int openCount, int m, int n, Boolean[][][] memo) {
        // 1. Boundary check
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        // 2. Update openCount for current cell
        openCount += (grid[i][j] == '(') ? 1 : -1;

        // 3. Pruning: if openCount drops below 0, or exceeds remaining steps
        if (openCount < 0 || openCount > (m - 1 - i) + (n - 1 - j)) {
            return false;
        }

        // 4. Destination base case
        if (i == m - 1 && j == n - 1) {
            return openCount == 0;
        }

        // 5. Check memo table
        if (memo[i][j][openCount] != null) {
            return memo[i][j][openCount];
        }

        // 6. Explore down and right
        boolean down = solve(grid, i + 1, j, openCount, m, n, memo);
        boolean right = solve(grid, i, j + 1, openCount, m, n, memo);

        // 7. Memoize and return
        return memo[i][j][openCount] = (down || right);
    }
}
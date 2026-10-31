class Solution {
    int count = 0;
    int[][][] dp;
    long MOD = 1_000_000_007L;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][3];

        for (int[][] arr : dp) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }

        boolean downMove = false;
        boolean rightMove = false;

        return solve(grid, 0, 0, m, n, downMove, rightMove);
    }

    public int solve(int[][] grid, int i, int j, int m, int n,
                     boolean downMove, boolean rightMove) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int state = 0;
        if (downMove) {
            state = 1;
        } else if (rightMove) {
            state = 2;
        }

        if (dp[i][j][state] != -1) {
            return dp[i][j][state];
        }

        long ans = 0; // use long to prevent overflow before modulo
        boolean isStart = (i == 0 && j == 0);

        if (grid[i][j] == 1 && !isStart) {
            if (downMove) {
                ans = (ans + solve(grid, i, j + 1, m, n, false, true)) % MOD;
            }

            if (rightMove) {
                ans = (ans + solve(grid, i + 1, j, m, n, true, false)) % MOD;
            }
        } else {
            // Move down
            ans = (ans + solve(grid, i + 1, j, m, n, true, false)) % MOD;

            // Move right
            ans = (ans + solve(grid, i, j + 1, m, n, false, true)) % MOD;
        }

        return dp[i][j][state] = (int) ans;
    }
}
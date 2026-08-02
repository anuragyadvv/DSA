class Solution {
    public boolean stoneGame(int[] piles) {
        int n= piles.length;
        int dp[][] = new int[501][501];

        for(int num[]:dp){
            Arrays.fill(num,-1);
        }

        int diff= solve(piles, 0, n-1,dp);
        if(diff>0){
            return true;
        }

        return false;
        
    }

    public int solve(int piles[],int i, int j, int dp[][]){
        if(i>j) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int takei = piles[i]-solve(piles,i+1,j,dp);
        int takej = piles[j]-solve(piles,i,j-1,dp);

        return dp[i][j] = Math.max(takei, takej);
    }
}
class Solution {
    public int stoneGameII(int[] piles) {
        int n= piles.length;
        int dp[][][] = new int[2][101][101];

        for(int row2D[][]:dp){
            for(int row[]:row2D){
                Arrays.fill(row,-1);
            }
        }

        // Alice=1;
        // Bob=0;

        return solveForAlice(piles,1,0,1,n,dp);
        
    }
    //    this function will give max score for alice
    public int solveForAlice(int piles[],int person, int i, int M, int n, int dp[][][]){
        if(i>=n) return 0;

        if(dp[person][i][M]!= -1){
            return dp[person][i][M];
        }

        int result = (person==1)? -1: Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1; x<= Math.min(2*M,n-i); x++){
              
              stones += piles[i+x-1];

              if(person==1){ // alice turn expect max 
               result = Math.max(result, stones+solveForAlice(piles,0,i+x,Math.max(M,x),n,dp));

              }else{  // bob turn(alice expect worse result for herself)

              result = Math.min(result,solveForAlice(piles,1,i+x,Math.max(M,x),n,dp));

              }
        }

        return dp[person][i][M] = result;
    }
}
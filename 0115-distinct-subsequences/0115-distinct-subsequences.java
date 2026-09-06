class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();
        

        int dp[][] = new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }

        return choices(s, t, n, m, 0, 0,dp);

    }

    public int choices(String s, String t, int n, int m, int i, int j,int dp[][]) {

        // base case 

        if (j == m) {
            return 1;
        }
        if (i == n) {
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

     

        if (s.charAt(i) == t.charAt(j)) { // we have two choices whether to include the character of s or not includes character of s 

            return dp[i][j]= choices(s, t, n, m, i + 1, j + 1,dp) + choices(s, t, n, m, i + 1, j,dp);

        } else { // if character do not match then we have one choice ie not include the character of s and do nothing with character of t 

            return dp[i][j] = choices(s, t, n, m, i + 1, j,dp);

        }
    }
}
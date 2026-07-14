class Solution {
    // using bottom up
    int MOD = 1000000007;
    
    public int subsequencePairCount(int[] nums) {

        int n = nums.length;
        int maxVal =0;
        for(int num : nums){
            maxVal = Math.max(maxVal,num);
        }

      int dp[][][] = new int[n+1][maxVal+1][maxVal+1];

    //    base case 
    for(int first =0 ;first<=maxVal; first++){
        for(int second = 0; second<=maxVal; second++){
            boolean bothNonEmpty = (first!=0 && second!=0);
            boolean gcdsMatch = (first==second);
            dp[n][first][second]=(bothNonEmpty && gcdsMatch)? 1:0;
        }
    }


    for(int i =n-1 ;i>=0;i--){
        for(int first =maxVal ; first>=0 ; first--){
            for(int second = maxVal ; second>=0 ; second--){
                int skip = dp[i+1][first][second];
                int takeSeq1 = dp[i+1][gcd(first,nums[i])][second];
                int takeSeq2 = dp[i+1][first][gcd(second, nums[i])];

                dp[i][first][second] = (int)((0L+skip+takeSeq1+takeSeq2)% MOD);
            }
        }
    }

    return dp[0][0][0];

      
    }

    // public int solve(int nums[], int i, int first , int second){

    //     if(i==nums.length){
    //         boolean bothNonEmpty = (first!=0 && second!=0);
    //         boolean gcdsMatch = (first== second);

    //         return (bothNonEmpty && gcdsMatch)? 1:0;
    //     }

    //     if(t[i][first][second]!= null){
    //         return t[i][first][second];
    //     }
        
    //     int skip = solve(nums, i+1, first,second);
    //     int takeSeq1 = solve(nums, i+1 , gcd(first,nums[i]), second);
    //     int takeSeq2 = solve(nums,i+1 , first, gcd(second,nums[i]));

    //     return t[i][first][second] = (int)((0L+skip+takeSeq1+takeSeq2)% MOD);
    // }



    public int gcd(int a, int b){

        return  (b==0)? a : gcd(b,a%b);
    }
}
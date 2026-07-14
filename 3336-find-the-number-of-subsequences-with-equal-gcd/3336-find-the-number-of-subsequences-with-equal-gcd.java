class Solution {
    int MOD = 1000000007;
    Integer t[][][] ;
    public int subsequencePairCount(int[] nums) {

        int n = nums.length;
        int maxVal =0;
        for(int num : nums){
            maxVal = Math.max(maxVal,num);
        }

       t = new Integer[n][maxVal+1][maxVal+1];

        int pairs = solve(nums,0,0,0); // i =0 , GCD1= 0 , GCD2 = 0 

       return pairs; 
    }

    public int solve(int nums[], int i, int first , int second){

        if(i==nums.length){
            boolean bothNonEmpty = (first!=0 && second!=0);
            boolean gcdsMatch = (first== second);

            return (bothNonEmpty && gcdsMatch)? 1:0;
        }

        if(t[i][first][second]!= null){
            return t[i][first][second];
        }
        
        int skip = solve(nums, i+1, first,second);
        int takeSeq1 = solve(nums, i+1 , gcd(first,nums[i]), second);
        int takeSeq2 = solve(nums,i+1 , first, gcd(second,nums[i]));

        return t[i][first][second] = (int)((0L+skip+takeSeq1+takeSeq2)% MOD);
    }



    public int gcd(int a, int b){

        return  (b==0)? a : gcd(b,a%b);
    }
}
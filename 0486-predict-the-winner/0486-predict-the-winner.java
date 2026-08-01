class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int diff = solve(0,n-1,nums);

        if(diff>=0){
            return true;
        }

        return false;
        
    }

    public int solve(int i , int j, int nums[]){
        if(i>j) return 0;
        if(i==j) return nums[i];

       int takei = nums[i]- solve(i+1,j,nums);
       int takej = nums[j]- solve(i,j-1,nums);

        return Math.max(takei, takej);
    }
}
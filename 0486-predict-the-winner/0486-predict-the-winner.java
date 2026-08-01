class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        int totalScore = 0;
        for(int i=0;i<n;i++){
            totalScore += nums[i];
        }

        // find the score when player 1 play optimally 
        int player1Score = solve(0,n-1,nums);

        int player2Score = totalScore - player1Score;

        if(player1Score>= player2Score){
            return true;
        } 

        return false;
        
    }
  
//   solve function only finds optimal score for player 1
    public int solve(int i , int j, int nums[]){
        
        if(i>j) return 0;

        if(i==j) return nums[i];

        int takei = nums[i] + Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int takej = nums[j] + Math.min(solve(i+1,j-1,nums), solve(i,j-2,nums));

        return Math.max(takei, takej);

    }
}
class Solution {
    // greedy+ bfs
    public int jump(int[] nums) {
        int n = nums.length;
        int totalJumps = 0;
        int destination = n-1;
        int  coverage = 0;
        int lastJumpIdx = 0;

        if(n==1){
            return 0;
        }

        for(int i=0;i<n;i++){
            coverage = Math.max(coverage,i+nums[i]);

            if(i==lastJumpIdx){
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we reached the destination alreday 
                 if(coverage>=n-1){
                return totalJumps;
            }
            }

           
        } 

        return totalJumps;
        
    }
}
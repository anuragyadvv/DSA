class Solution {
    public int minMoves(int[] nums) {
        // int n = nums.length;
        // int maxVal = Integer.MIN_VALUE;
        // int maxIdx = -1;

        // for(int i=0;i<n;i++){
        //     if(nums[i]>maxVal){
        //         maxVal = nums[i];
        //         maxIdx = i;
        //     }
        // }

        // int totalMoves = 0;

        // for(int i=0;i<n;i++){
        //     if(i==maxIdx) continue;

        //     totalMoves += maxVal - nums[i];

        // }

        // return totalMoves;
        

        // Approach -2 (we will try to make all number equal to max number in the array )
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum =0;

        for(int i=0;i<n;i++){
            sum += nums[i];

            max = Math.max(max, nums[i]);
        }

        return max*n - sum ; // means this much difference I need to fill to make all elements equal to max 
    }
}
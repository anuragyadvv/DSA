class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        int maxIdx = -1;

        for(int i=0;i<n;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        int totalMoves = 0;

        for(int i=0;i<n;i++){
            if(i==maxIdx) continue;

            totalMoves += maxVal - nums[i];

        }

        return totalMoves;
        
    }
}
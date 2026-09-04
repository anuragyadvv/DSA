class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // Brute force 

        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxVal = Math.max(maxVal,nums[i]);
            int minVal = Integer.MAX_VALUE;

            for(int j=i;j<n;j++){
                minVal = Math.min(minVal,nums[j]);
            }

            if(maxVal-minVal <= k){
                return i;
            }
        }

        return -1;
        
    }
}
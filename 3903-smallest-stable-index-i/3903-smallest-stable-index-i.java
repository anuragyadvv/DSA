class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // Brute force 

        // int n = nums.length;
        // int maxVal = Integer.MIN_VALUE;

        // for(int i=0;i<n;i++){
        //     maxVal = Math.max(maxVal,nums[i]);
        //     int minVal = Integer.MAX_VALUE;

        //     for(int j=i;j<n;j++){
        //         minVal = Math.min(minVal,nums[j]);
        //     }

        //     if(maxVal-minVal <= k){
        //         return i;
        //     }
        // }

        // return -1;


        // optimized ( find minFromIdx in advance )

        int n = nums.length;
        int minEl = Integer.MAX_VALUE;

        int minFromIdx[] = new int[n];

        for(int i = n-1;i>=0;i--){
            minEl = Math.min(minEl,nums[i]);
            minFromIdx[i] = minEl;
        }

        int maxEl = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxEl = Math.max(maxEl,nums[i]);
            minEl = minFromIdx[i];

            if((maxEl-minEl)<=k){
                return i;
            }
        }

        return -1;

        
    }
}
class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        int minEl = Integer.MAX_VALUE;
        int minFromIdx[] = new int[n];

        for(int i=n-1;i>=0;i--){
            minEl = Math.min(minEl,nums[i]);
            minFromIdx[i] = minEl;
        }

        int maxEl = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxEl = Math.max(maxEl,nums[i]);

            if(maxEl-minFromIdx[i]<=k){
                return i;
            }
        }
       return -1; 
        
    }
}
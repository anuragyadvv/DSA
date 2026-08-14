class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;

        for(int i=0;i<n-k+1;i++ ){
           int currSum =0;
           for(int j=i;j<i+k;j++){
            currSum += nums[j];
           }
           double avg =(double) currSum/k;
           maxAvg = Math.max(maxAvg,avg); 
        }

        return maxAvg;
        
    }
}
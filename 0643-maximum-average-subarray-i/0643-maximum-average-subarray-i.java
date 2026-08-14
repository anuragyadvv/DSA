class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Brute force (O(n2))
        // int n = nums.length;
        // double maxAvg = Integer.MIN_VALUE;

        // for(int i=0;i<n-k+1;i++ ){
        //    int currSum =0;
        //    for(int j=i;j<i+k;j++){
        //     currSum += nums[j];
        //    }
        //    double avg =(double) currSum/k;
        //    maxAvg = Math.max(maxAvg,avg); 
        // }

        // return maxAvg;


        // optimized(using sliding window ) O(n)
        int n= nums.length;
         if(n<k) return -1;
         double maxAvg = Integer.MIN_VALUE; 
         int currSum=0;
         for(int i=0;i<k;i++){
            currSum += nums[i];
         }
         maxAvg = Math.max(maxAvg,(double)currSum/k);

         for(int i =k;i<n;i++){
            currSum += nums[i]-nums[i-k];
            maxAvg = Math.max(maxAvg,(double)currSum/k);
         }
        
       return maxAvg;

    }
}
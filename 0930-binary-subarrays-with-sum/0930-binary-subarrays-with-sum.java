class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            int currSum =0;
            for(int j=i;j<n;j++){
                currSum += nums[j];
                if(currSum == goal){
                    count++;
                }
            }
        }

        return count;
    }
}
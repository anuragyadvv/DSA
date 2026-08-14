class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // using sliding window (uses two pinter)
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        long maxSum = 0;
        long currWindow =0;
        int i=0; // left
        int j=0; // right

        while(j<n){
            // check if nums[j] is already present in curr window nums[i...j]
            while(set.contains(nums[j])){
               currWindow -= nums[i];
               set.remove(nums[i]);
               i++;
            }
            currWindow += nums[j];
            set.add(nums[j]);

            if(j-i+1==k){
                maxSum = Math.max(maxSum,currWindow);
                currWindow -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return maxSum;
        
    }
}
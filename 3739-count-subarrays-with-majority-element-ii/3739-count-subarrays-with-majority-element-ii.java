class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long totalSubarrays = 0;
        
        // Since prefix sums can range from -n to +n, we shift indices by +n
        // Size is 2 * n + 1 to handle both negative and positive ranges safely
        int[] prefixSumFreq = new int[2 * n + 1];
        
        int currentPrefixSum = 0;
        
        // Base case: Before processing any element, prefix sum is 0.
        // Shifted index for 0 is (0 + n) = n
        prefixSumFreq[0 + n] = 1;
        
        // Running count of how many valid starting prefix sums are less than current
        int validPreviousCount = 0;

        for (int i = 0; i < n; i++) {
            // Step 1: Update current prefix sum using +1 / -1 logic
            if (nums[i] == target) {
                // If we hit target, prefix sum INCREASES.
                // This means the old prefix sum value is now strictly less than our new one!
                validPreviousCount += prefixSumFreq[currentPrefixSum + n];
                currentPrefixSum++;
            } else {
                // If we hit a non-target, prefix sum DECREASES.
                // This means we lose the frequencies of the new lower boundary sum.
                currentPrefixSum--;
                validPreviousCount -= prefixSumFreq[currentPrefixSum + n];
            }

            // Step 2: Add all valid starting positions to our answer
            totalSubarrays += validPreviousCount;

            // Step 3: Record the current prefix sum in our frequency tracker
            prefixSumFreq[currentPrefixSum + n]++;
        }

        return totalSubarrays;
    }
}
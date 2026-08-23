class Solution {
    public long subArrayRanges(int[] nums) {

        // Brute force O(n2)
        int n = nums.length;
        long result =0;
        for(int i=0;i<n;i++){
            int minVal = nums[i];
            int maxVal = nums[i];
            for(int j=i;j<n;j++){
                minVal = Math.min(minVal,nums[j]);
                maxVal = Math.max(maxVal,nums[j]);
                result = (result + (maxVal-minVal));
            }
        }

        return result;
    }
}
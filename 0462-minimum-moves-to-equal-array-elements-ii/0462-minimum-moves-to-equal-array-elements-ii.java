class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int mid = n/2;
        int moves = 0;

        for(int i=0;i<mid;i++){
           moves += nums[mid] - nums[i]; 
        }

        for(int i=mid+1;i<n;i++){
            moves += nums[i] - nums[mid];
        }

        return moves;
        
    }
}
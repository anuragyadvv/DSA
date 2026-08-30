class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIdx =0;
        int maxIdx = 0;

        for(int i=0;i<n;i++){

            if(nums[i]< nums[minIdx]){
                minIdx =i;
            }

            if(nums[i]>nums[maxIdx]){
                maxIdx =i;
            }
        }


      int left = Math.min(minIdx,maxIdx);
      int right = Math.max(minIdx,maxIdx);

      int bothleft = right+1;
      int bothRight = n- left;
      int fromBothEnd = (left+1) +(n-right);

      return Math.min(bothleft,Math.min(bothRight,fromBothEnd));
        
    }
}
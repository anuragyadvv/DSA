class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int n = nums.length;
        int len = 1;

        for(int i=0;i<n;i++){

            boolean isInc = true;
            boolean isDec = true;
            for(int j=i+1;j<n;j++){

                if(nums[j]>nums[j-1]){
                    isDec =false;
                }
                else if(nums[j]<nums[j-1]){
                    isInc = false;
                }
                else{
                    isInc = false;
                    isDec = false;
                }

                if(isInc == false && isDec == false){
                    break;
                }

                if(isInc || isDec){
                    len = Math.max(len, j-i+1);
                }
             
            }
        }

        return len;
        
    }
}
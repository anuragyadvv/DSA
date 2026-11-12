class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int n = nums.length;
        int len = 1;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){


                boolean isInc =  true;
                for(int k=i;k<j;k++){
                    if(nums[k]>=nums[k+1]){
                        isInc = false;
                        break;
                    }
                }

                if(isInc){
                    len = Math.max(len,(j-i+1));
                }

                boolean isDec = true;

                 for(int k=i;k<j;k++){
                    if(nums[k]<=nums[k+1]){
                        isDec = false;
                        break;
                    }
                }

                if(isDec){
                    len = Math.max(len,(j-i+1));
                }
            }
        }

        return len;
        
    }
}
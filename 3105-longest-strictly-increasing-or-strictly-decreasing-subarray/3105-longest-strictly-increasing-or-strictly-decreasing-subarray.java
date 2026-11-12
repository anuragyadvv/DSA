class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        //  int n = nums.length;
        // int len = 1;

        // for(int i=0;i<n;i++){

        //     boolean isInc = true;
        //     boolean isDec = true;
        //     for(int j=i+1;j<n;j++){

        //         if(nums[j]>nums[j-1]){
        //             isDec =false;
        //         }
        //         else if(nums[j]<nums[j-1]){
        //             isInc = false;
        //         }
        //         else{
        //             isInc = false;
        //             isDec = false;
        //         }

        //         if(isInc == false && isDec == false){
        //             break;
        //         }

        //         if(isInc || isDec){
        //             len = Math.max(len, j-i+1);
        //         }
             
        //     }
        // }

        // return len;


        // Approach -3 (O(n))

        int n = nums.length;
        int inc = 1;
        int dec = 1;
        int res = 1;

        for(int i=1;i<n;i++){

            if(nums[i]>nums[i-1]){ // increasing
                inc++;
                dec=1;

                res = Math.max(res, inc);
            }
            else if(nums[i]<nums[i-1]){ // decreasing
                dec++;
                inc =1;

                res = Math.max(res,dec);
            }
            else { // equal elements
                inc = 1;
                dec = 1;
            }
        }

        return res;
        
    }
}
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        // int n = nums.length;
        // int count =0;
        // for(int i=0;i<n;i++){
        //     int max = nums[i];
        //     int min = nums[i];
        //     for(int j=i;j<n;j++){
        //         max = Math.max(max,nums[j]);
        //         min = Math.min(min, nums[j]);

        //         if(min==minK && maxK == max){
        //             count++;
        //         }

        //     }
        // }

        // return count;


        // M2 
        int n = nums.length;
        long ans = 0;

        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIdx = -1;

        for(int i=0;i<n;i++){
            if(nums[i]< minK ||  nums[i]>maxK){
                culpritIdx = i;
            }

            if(nums[i]==minK){
                minKPosition  = i;
            }

            if(nums[i]==maxK){
                maxKPosition = i;
            }

           long smaller = Math.min(minKPosition, maxKPosition);
           long temp = smaller - culpritIdx;

           ans += (temp<=0)? 0: temp;
        }   

        return ans;     
    }
}
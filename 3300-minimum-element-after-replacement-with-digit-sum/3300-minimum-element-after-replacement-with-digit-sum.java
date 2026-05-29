class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n ; i++){
            int sum =0;
            int num = nums[i];
            while(num>0){
                int rem = num% 10;
                sum += rem ;
                num = num/10;
            }

            nums[i]= sum;
        }

        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minimum = Math.min(minimum,nums[i]);
        }


        return minimum;
        
    }
}
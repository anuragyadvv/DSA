class Solution {
    public int maximumProduct(int[] nums) {
      
    //   int maxProduct= Integer.MIN_VALUE;

    //   for(int i=0;i< nums.length-2;i++){
    //     for(int j=i+1;j< nums.length-1;j++){
    //         for(int k=j+1;k< nums.length;k++){
    //             int ans = nums[i]*nums[j]*nums[k];

    //             maxProduct = Math.max(maxProduct,ans);
    //         }
    //     }
    //   }
    //   return maxProduct;

    Arrays.sort(nums);

   int n=nums.length-1;

   int prod1= nums[n]*nums[n-1]*nums[n-2];
   int prod2= nums[0]*nums[1]*nums[n];

   return Math.max(prod1,prod2);
        
    }
}
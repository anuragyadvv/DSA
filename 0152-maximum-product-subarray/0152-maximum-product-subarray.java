class Solution {
    public int maxProduct(int[] nums) {
        // brute force is to find all subarrays using 3 loops and store their multiplication and store max one and return it it will give time complexity of O(n3)

        // Brute force - O(n2)
        int n= nums.length;
        int maxProd = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int currProd = 1;
            for(int j=i;j<n;j++){
                currProd *= nums[j];
                maxProd = Math.max(maxProd, currProd);
            }
        }

        return maxProd;



        // int prefix=1;
        // int suffix=1;
        // int n = nums.length;
        // int ans = Integer.MIN_VALUE;

        // for(int i=0;i<n;i++){
        //     if(prefix==0) prefix=1;
        //     if(suffix==0) suffix=1;

        //     prefix = prefix*nums[i];
        //     suffix = suffix*nums[n-i-1];
        //     ans = Math.max(ans,Math.max(prefix,suffix));
        // }

        // return ans;
        
    }
}
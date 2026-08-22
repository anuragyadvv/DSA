class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    // Brute force (O(n2))
    // int n = nums.length;
    // int count = 0; 
    // for(int i=0;i<n;i++){
    //     long prod =1;
    //     for(int j=i;j<n;j++){
    //        prod *= nums[j];

    //        if(prod<k){
    //         count++;
    //        }else{
    //         break;
    //        }
    //     }
    // }

    // return count;

    // M2 ( sliding window)
    int n= nums.length;
    if(k<=1){
        return 0;
    }
    int count =0;
    long prod = 1;
    int i=0;
    int j=0;

    while(j<n){
        prod = prod*nums[j];

        while(prod>=k && i<=j){
            prod /= nums[i];
            i++;
        }

       count += (j-i+1);
       j++;
    }

    return count;
     
        
    }
}
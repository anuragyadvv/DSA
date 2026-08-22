class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    // Brute force 
    int n = nums.length;
    int count = 0; 
    for(int i=0;i<n;i++){
        long prod =1;
        for(int j=i;j<n;j++){
           prod *= nums[j];

           if(prod<k){
            count++;
           }else{
            break;
           }
        }
    }

    return count;
        
    }
}
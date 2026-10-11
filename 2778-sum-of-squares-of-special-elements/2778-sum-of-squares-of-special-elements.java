class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int x =0;
        int sum =0;

        for(int i=0;i<n;i++){

            x= i+1;

            if(n%x==0){
                sum += (nums[i]*nums[i]);
            }
        }

        return sum;
        
    }
}
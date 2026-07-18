class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int smallest= Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            smallest = Math.min(smallest,nums[i]);
            largest = Math.max(largest, nums[i]);
        }

        return gcd(smallest,largest);

        
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a= b;
            b= temp;
        }
        return a;
    }
}
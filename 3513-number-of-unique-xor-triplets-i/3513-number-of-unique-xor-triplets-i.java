class Solution {
    public int uniqueXorTriplets(int[] nums) {
       int n= nums.length;
        if(n==1 || n==2){
            return n;
        }

        // for n>=3 find nearest 2^x of n that will be answer 

        int ans = 1; // 2^0

        while(ans<= n){
            ans*=2;
        }

        return ans;
        
    }
}
class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mxi = Integer.MIN_VALUE;
        int prefixGcd[] = new int[n];

        for(int i=0;i<n;i++){
            mxi = Math.max(nums[i],mxi);
            prefixGcd[i] = gcd(nums[i], mxi);
        } 

        Arrays.sort(prefixGcd);
        long sum =0;

        int i = 0;
        int j = n-1;
        while(i<j){
           int a = prefixGcd[i];
           int b = prefixGcd[j];
           sum+= gcd(a,b);

           i++;
           j--;
        }

        return sum;
        
    }

    public int gcd(int a , int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b = temp;
        }

        return a;
    }
}
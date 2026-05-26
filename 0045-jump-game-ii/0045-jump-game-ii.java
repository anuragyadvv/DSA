class Solution {
    // tabulation 
    public int jump(int[] nums) {
        int n = nums.length;
        int t[] = new int[n];

        Arrays.fill(t,10001);

       t[0]= 0; 
    //    t[i] means jumps required to reach index i
    for(int i=0;i<n;i++){
        for(int j=1;j<=nums[i];j++){
            if(j+i<n){
                t[i+j]= Math.min(t[i+j],t[i]+1);
            }
        }
    }

    return t[n-1];

        
    }
}
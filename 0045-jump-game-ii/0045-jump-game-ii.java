class Solution {
    // memoization
    public int jump(int[] nums) {
        int n = nums.length;
       int t[] = new int[n];
       Arrays.fill(t,-1);
       return  solve (nums,0,n,t);
        
    }
 
    public int solve(int nums[],int idx, int n,int t[]){
        if(idx>=n-1){
             return 0;
        }

        if(t[idx]!=-1){
            return t[idx];
        }

        int minJump = 10001;

        for(int i=1;i<=nums[idx];i++){
            int jump = solve(nums,idx+i,n,t);
            minJump = Math.min(minJump,jump+1);

        }

        return t[idx]= minJump;
    }
}
class Solution {
       int t[][];
    public int combinationSum4(int[] nums, int target) {

        
        int n = nums.length;
        t = new int[201][1001];

        for(int row[]:t){
            Arrays.fill(row,-1);
        }
        
        return solve(nums,0, target,n);
    }

    public int solve(int nums[],int idx , int target, int n ){

        if(target==0){
            return 1;
        }
        if(idx>= n || target<0){
            return 0;
        }

        if(t[idx][target]!=-1){
            return t[idx][target]; 
        }

        
        int take = solve(nums , 0, target-nums[idx],n);
        
        int notTake = solve(nums,idx+1, target,n);

        

        return t[idx][target] = take+notTake;
    }
}
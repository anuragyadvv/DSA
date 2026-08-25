class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int i=1;i<=101;i++){
            if(!set.contains(k*i)){
                return k*i;
            }
        }

        return -1;
    }
}
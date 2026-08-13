class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        int l=0; // left 
        int maxLength = Integer.MIN_VALUE;

        for(int r=0;r<n;r++){
            int key = nums[r];
            map.put(key,map.getOrDefault(key,0)+1);

            while(map.get(key)>k){
                int left = nums[l];
                map.put(left,map.get(left)-1);
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // brute force O(n2)
        int  n = nums.length;
        int arr[] = new int[2];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
               if(nums[i]+nums[j]==target){
                arr[0]=i;
                arr[1] = j;
               }
            }
        }

        return arr;



        // optimized - O(n)
        // HashMap<Integer,Integer>map= new HashMap<>(); //store element and its index
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],i);
        // }

        // for(int i=0;i<nums.length;i++){

        //     int val = target - nums[i];
        //     if(map.containsKey(val) && map.get(val)!=i){
        //         return new int[]{i,map.get(val)};
        //     }
        // }

        // return new int[]{};
        
    }
}
class Solution {
    int result;
    
    public int beautifulSubsets(int[] nums, int k) {

        result =0;
        
        Map<Integer,Integer> map = new HashMap<>();
        solve(nums,0,map,k);

        return result-1; // -1 because we don't want to count the empty subset in the result
        
    }

    public void solve(int nums[],int i, Map<Integer,Integer>map, int k){
        if(i==nums.length){
            result++;
            return;
        }

        // not take 
        solve(nums,i+1,map,k);

        // take
        if(!map.containsKey(nums[i]-k) && !map.containsKey(nums[i]+k)){

            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            solve(nums,i+1,map,k);

            map.put(nums[i], map.get(nums[i])-1);

            if(map.get(nums[i])==0){
                map.remove(nums[i]);
            }

        }
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {

        // HashMap<Integer,Integer> map = new HashMap<>();

        // map.put(0,1);
        // int sum=0;
        // int ans=0;

        // for(int j=0;j<nums.length;j++){
        //     sum+=nums[j];

        //     if(map.containsKey(sum-k)){
        //         ans+=map.get(sum-k);
        //     }

        //     map.put(sum , map.getOrDefault(sum,0)+1);
        // }
        
        // return ans;


        int n = nums.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = nums[0];
        int count =0;

        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =(i==0)? prefixSum[j]: prefixSum[j]-prefixSum[i-1];

                if(sum==k){
                    count++;
                }
            }
        }

        return count;

    }
}
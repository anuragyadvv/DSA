class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        // brute force (TLE)
        int n = nums.length;
        int count = 0;
        // for(int i=0;i<n;i++){
        //     int currSum =0;
        //     for(int j=i;j<n;j++){
        //        currSum += nums[j];
        //        if(currSum%k==0){
        //         count++;
        //        }
        //     }
        // }

        // return count;

        // using prefix sum approach (TLE)
        // int prefixSum[] = new int[n];
        // prefixSum[0]=nums[0];
        // for(int i=1;i<n;i++){
        //     prefixSum[i] = prefixSum[i-1]+nums[i];
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum = (i==0)? prefixSum[j]:prefixSum[j]-prefixSum[i-1];
        //         if(sum%k==0) count++;
        //     }
        // }

        // return count;


        // optimized(hashMap) O(n)
        HashMap<Integer,Integer> map = new HashMap<>(); // key = remainder value = frequency of remainder 
        int sum =0;
        map.put(0,1); // first sum%k and its frquency initially sum =0 
        for(int i=0;i<n;i++){
            sum += nums[i];
            int rem = sum%k;
            if(rem<0) rem+=k;

            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        return count;
        
    }
}
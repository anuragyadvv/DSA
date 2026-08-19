class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Brute force = O(n2 )(not give TLE)
        // int n = nums.length;
        // int count =0;
        // for(int i=0;i<n;i++){
        //     int currSum =0;
        //     for(int j=i;j<n;j++){
        //         currSum += nums[j];
        //         if(currSum == goal){
        //             count++;
        //         }
        //     }
        // }

        // return count;


        // m2 - using prefixSum approach (O(n2))(TLE)
        // int n = nums.length;
        // int count =0;
        // int prefixSum[] = new int[n];
        // prefixSum[0]= nums[0];
        // for(int i=1;i<n;i++){
        //     prefixSum[i] = prefixSum[i-1]+nums[i]; 
        // } 

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum = (i==0)? prefixSum[j]: prefixSum[j]- prefixSum[i-1];
        //         if(sum==goal){
        //             count++;
        //         }
        //     }
        // }

        // return count;

        int n = nums.length;
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>(); // store currSum as key and their frequency as value 
        int currSum =0;
        map.put(0,1); // initially currSum =0 and its frequency =1 
        for(int i=0;i<n;i++){
            currSum += nums[i];

            if(map.containsKey(currSum-goal)){
                count += map.get(currSum- goal);
            }

            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
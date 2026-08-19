class Solution {
    public int findMaxLength(int[] nums) {
        // int n = nums.length;
        // int maxLen = -1;
        // for(int i=0;i<n;i++){
        //     int countZero =0;
        //     int countOne =0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0){
        //            countZero++;
        //         }
        //         else{
        //          countOne++;
        //         } 

        //         if(countZero==countOne){
        //             maxLen = Math.max(maxLen, countZero+countOne);
        //         }
        //     }
        // }

        // if(maxLen==-1){
        //     return 0;
        // }

        // return maxLen;


        // optimized (HashMap)
        // approach - treat 0 as -1 so the target sum will be zero and that subarray should have maxLength 
        int n = nums.length;
        int maxLen = -1;
        HashMap<Integer,Integer> map = new HashMap<>(); // key = sum and value = index 
        int currSum =0;
        map.put(0,-1); // initially currSum is zero 

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                currSum = currSum -1;
            }else{
                currSum += 1;
            }

            if(map.containsKey(currSum)){
                int startIdx = map.get(currSum);
                maxLen = Math.max(maxLen,i-startIdx );

            }
            else{
                map.put(currSum,i);
            }
        }

        if(maxLen==-1){
            return 0;
        }

        return maxLen;

        
    }
}
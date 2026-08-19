class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Brute force
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     int sum =0;
        //     for(int j=i;j<n;j++){
        //        sum += nums[j];
        //        if((j-i+1)>=2  && sum %k==0){
        //         return true;
        //        }
        //     }
        // }

        // return false;

        // m2: using prefixSum 
        // int n = nums.length;
        // int prefixSum[] = new int[n];
        // prefixSum[0] = nums[0];
        // for(int i=1;i<n;i++){
        //     prefixSum[i]= prefixSum[i-1]+nums[i];
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){

        //         int sum =(i==0)? prefixSum[j]: prefixSum[j]-prefixSum[i-1];
        //         if((j-i+1)>=2 && sum%k ==0 ){
        //             return true;
                    
        //         } 
        //     }
        // }

        // return false;

    //    optimized (using HashMap)
    int n = nums.length;
    HashMap<Integer,Integer> map = new HashMap<>(); // store remainder as key and index as value 
     int sum =0;
     map.put(0,-1);

     for(int i=0;i<n;i++){
        sum += nums[i];
        int rem = sum%k;

        if(map.containsKey(rem)){
            int startIdx = map.get(rem);
            if((i-startIdx)>=2){
                return true;
            }
        }else{
           map.put(rem,i);
        }
       
     }

     return false;
        
    }
}
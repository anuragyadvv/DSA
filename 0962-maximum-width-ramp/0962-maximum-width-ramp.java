class Solution {
    public int maxWidthRamp(int[] nums) {
        // Brute force 
        // int n = nums.length;
        // int maxWidth = 0;

        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[j]>= nums[i]){
        //             maxWidth = Math.max(maxWidth, j-i);
        //         }
        //     }
        // }

        // return maxWidth;

        // optimized (using monotonic stack specifically decreasing stack )(this question is best for understanding monotonic stack when to use incresing stack and when to use decresaing stack if do not have idea then apply both and check which one is giving answer )
        int n = nums.length;
        int maxWidth = 0;
        Stack<Integer> s = new Stack<>(); // store in decreasing order (store index)
        // made decreasing stack
        s.push(0);
        for(int i=1;i<n;i++){
             if(nums[s.peek()]>=nums[i]){
                s.push(i);
             }
        }

        //  two pointers 
        int j= n-1 ;
        while(!s.isEmpty() && j>=0){

            if(nums[j]>= nums[s.peek()]){
                maxWidth = Math.max(maxWidth, (j-s.peek()));
                s.pop();
                if(s.isEmpty()){
                    return maxWidth;
                }
            }

            else if(nums[j]<nums[s.peek()]) j--;

            
        }


   return maxWidth;

        
    }
}
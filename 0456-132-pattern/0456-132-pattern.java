class Solution {
    public boolean find132pattern(int[] nums) {

        // Brute force O(n3)
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1; k<n;k++){
        //             if(nums[i]<nums[k] && nums[k]<nums[j]){
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;


        //Better Approach -O(n2) 

        // int n = nums.length;
        // int num_i = nums[0];   // let assume it , it is a min and update the min element 

        // for(int j=1;j<n-1;j++){
        //     num_i = Math.min(num_i, nums[j]);

        //     for(int k=j+1;k<n;k++){

        //         if(num_i < nums[k] && nums[k]<nums[j]){
        //             return true;
        //         }
        //     }
        // } 

        // return false;


        // Best approach - why stack - when one loop is depenedent on other loop like jstarts from i+1 and k starts from j+1 in these cases try using stack 
        int n = nums.length;

        int num3 = Integer.MIN_VALUE;

        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0 ; i--){

            if(nums[i]<num3){
                return true;
            }

            while(!s.isEmpty() && s.peek()< nums[i]){
                 num3 = s.peek();
                s.pop();
            }

            s.push(nums[i]);
        }

       return false;
        
    }
}
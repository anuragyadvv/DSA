class Solution {
    public int maxProduct(int[] nums) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // minheap 

        // for(int i=0;i<nums.length;i++){
        //     pq.add(nums[i]);
        // }

        // while(pq.size()>2){
        //     pq.remove();

        // }

        // int num1=pq.remove();
        // int num2= pq.remove();

        // return (num1-1)*(num2-1);


        // M-2 
        int n= nums.length;
        int max=0;
        int secondMax=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                secondMax= max;
                max=nums[i];
                
            }else if(nums[i]> secondMax){
                secondMax= nums[i];
            }
        }

        return (max-1)*(secondMax-1);
        
    }
}
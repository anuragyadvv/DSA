class Solution {
    public int maxProduct(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minheap 

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        while(pq.size()>2){
            pq.remove();

        }

        int num1=pq.remove();
        int num2= pq.remove();

        return (num1-1)*(num2-1);
        
    }
}
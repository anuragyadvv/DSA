class Solution {
    public boolean uniformArray(int[] nums1) {

        int minElement = Integer.MAX_VALUE;

        for(int num : nums1){
            minElement = Math.min(minElement,num);
        }

        if(minElement %2 ==1){ // if smallest no is odd no then we can make odd 
            return true; //we can make all nums2 odd 
        }

        // check if we can make all even in nums2 
        for(int num : nums1){
            if(num%2==1){
                return false;
            }
        }

        return true; // all nums2 will be even
        
    }
}
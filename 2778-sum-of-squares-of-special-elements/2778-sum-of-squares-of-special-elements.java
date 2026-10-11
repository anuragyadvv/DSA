class Solution {
    public int sumOfSquares(int[] nums) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int totalSquareSum =0;

        for(int i=1;i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
        }


        for(int idx : list){

            int num = nums[idx-1];

            totalSquareSum += (num*num);
        }

        return totalSquareSum;

      
        
    }
}
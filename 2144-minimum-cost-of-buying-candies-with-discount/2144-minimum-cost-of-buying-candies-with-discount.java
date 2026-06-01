class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int minSum =0;

        Arrays.sort(cost);


        int i =n-1; // buy the most expensive candy first so we can get the next most expensive candy for free 
        while(i>=0){

            minSum += cost[i];
            i--;

            if(i>=0){
                minSum += cost[i];
                i--;
            }


    //    skip the third candy 
            i--;
        
        }

        return minSum;
        
    }
}
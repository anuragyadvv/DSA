class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

       long totalCost = 0;

        if(cost1+(long)cost2<= costBoth){// take seprately both type 1 and type2 

        totalCost = ((long)cost1*need1) + ((long)cost2*need2);

        }

        else {
            int both = Math.min(need1, need2);
            totalCost = (long)costBoth * both;

            need1 -= both;
            need2 -= both;

            if(need1>0){
                totalCost += (long) need1 * Math.min(cost1, costBoth);
            }
            else{
                totalCost += (long) need2 *Math.min(cost2, costBoth);
            }
        }

        return totalCost;
        
    }
}
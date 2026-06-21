class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int count =0 ;
        countingSort(costs);

        for(int i=0;i<n;i++){
            if(coins>0 && costs[i]<= coins){
                count++;
                coins = coins- costs[i];
            }
        }

        return count;
        
    }

    public void countingSort(int costs[]){
        int n = costs.length;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max = Math.max(max,costs[i]);
        }

        int count[] = new int[max+1];

        for(int i=0;i<n;i++){
            count[costs[i]]++;
        }

        int index =0 ;
        for(int i=0;i<count.length;i++){
             while(count[i]>0){
                costs[index++]= i;
                count[i]--;
             }
        }

    }
}
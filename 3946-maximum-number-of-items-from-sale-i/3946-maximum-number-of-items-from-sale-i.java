class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int copies[] = new int[n]; // copies[i] = count of copies if I buy ith item 
        int minPrice = Integer.MAX_VALUE;

        int t[][] = new int[1001][1501];

        for(int row[] : t){
            Arrays.fill(row,-1);
        }



        for(int i=0;i<n;i++){

            minPrice = Math.min(minPrice, items[i][1]);
            int copy = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;

                if(items[j][0] % items[i][0]== 0){
                    copy++;
                }
            }

            copies[i] = copy;
        } 


        return solve(n, budget,minPrice,  items, copies,t );
        
    }

    public int solve(int n , int budget, int minPrice, int items[][], int copies[], int t[][]){

        if(n==0) {
            return budget/minPrice;
        }

        if(t[n][budget] != -1) return t[n][budget];

        int take = 0 ;
        int price = items[n-1][1];

        if(price<= budget){
            take = 1+copies[n-1]+ solve(n-1, budget-price, minPrice, items, copies,t);
        }

        int skip = solve(n-1,budget,minPrice,items,copies,t);

        return t[n][budget] =  Math.max(take,skip);
    }
}
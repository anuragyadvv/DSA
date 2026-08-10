class Solution {
    Boolean memo[];
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n+1];
        return solve( n);
       
        
    }

    public boolean solve(int n){
        if(n==0){
            return false;
        }
        if(n==1) return true;
        int sqrt =(int)Math.sqrt(n);
        if(sqrt*sqrt==n) return true;

        if(memo[n]!=null) return memo[n];

        for(int i=1;i*i<=n;i++){
           
        //if bob loses then alice wins 
           if(solve(n-(i*i))==false){ // condition for bob looses 
            return memo[n]= true;
           }
        }

        return memo[n]= false;
    }
}
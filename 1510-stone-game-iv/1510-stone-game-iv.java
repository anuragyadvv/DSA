class Solution {
    // tabulation
    public boolean winnerSquareGame(int n) {
       boolean t[] = new boolean[n+1];

    //    base case for i=0
    t[0]= false;

        for(int i=1;i<n+1;i++){
            for(int j=1;j*j<=i;j++){

                if(t[i-(j*j)]==false){
                    t[i]=true;
                    break;
                }
            }
        }

        return t[n];
       
        
    }
}
class Solution {
    public int smallestNumber(int n, int t) {
        int ans = -1;

        for(int i=n;i<=100;i++){
            int digitProduct =1;
              int j =i;
            while(j!=0){
                int rem = j%10;
                digitProduct *= rem;
                j= j/10; 
            }

            if(digitProduct %t==0){
               ans = i;
               break;
            }
        }

        return ans;
        
    }
}
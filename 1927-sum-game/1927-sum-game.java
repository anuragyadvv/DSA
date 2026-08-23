class Solution {
    public boolean sumGame(String num) {
        int n= num.length();
        int qDiff = 0;
        int sumDiff =0;

        for(int i=0;i<n/2;i++){
            char ch = num.charAt(i);

            if(ch=='?'){
                qDiff++;
            }else{
                sumDiff += (ch-'0');
            }
        }

        for(int i=n/2 ;i<n;i++){
            char ch = num.charAt(i);
            if(ch=='?'){
                qDiff--;
            }else{
                sumDiff -= (ch-'0');
            }
        }

        if(Math.abs(qDiff)%2 !=0){ // no of question mark is odd then alice always win because she will control the last move 
            return true;
        }

        return ((sumDiff*2) + (9*qDiff)) !=0;
        
    }
}
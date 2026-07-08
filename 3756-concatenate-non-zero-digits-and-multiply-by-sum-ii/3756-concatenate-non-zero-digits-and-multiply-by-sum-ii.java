class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long MOD = 1000000007;
        long digitSum[] = new long[n];
        long numberUpto[] = new long[n];
        int nonZeroDigit[] = new int[n];
        long pow10[] = new long [n+1];
        pow10[0] =1;

        for(int i=1;i<=n;i++){
            pow10[i] = (pow10[i-1]*10)% MOD;
        }


    //  making digitSum array
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int digit = ch - '0';
            
                if(i==0){
                    digitSum[i]= digit;
                }else{
                    digitSum[i] = digitSum[i-1]+ digit;
                }
            
        }


        //  making numberUpto array 
        numberUpto[0] = s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            char ch = s.charAt(i);
            int digit = ch-'0';

            if(digit!=0){
                numberUpto[i]= ((numberUpto[i-1]*10)+ digit) % MOD;

            }else{
                numberUpto[i] = numberUpto[i-1];
            }


        }



//    making nonZeroDigit array
        for(int i=0;i<n;i++){
             char ch = s.charAt(i);
             if(ch!= '0'){
                if(i==0){
                    nonZeroDigit[i]= 1;
                }else{
                    nonZeroDigit[i]= nonZeroDigit[i-1]+1;
                }
             }else{
                if(i!=0){
                   nonZeroDigit[i] = nonZeroDigit[i-1];
                }
                
             }
        }

        int q = queries.length;
        int ans[] = new int [q];
        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            // x*sum 
            long sum = digitSum[r]-((l==0)? 0: digitSum[l-1]);

            int k = nonZeroDigit[r] -((l==0)? 0 : nonZeroDigit[l-1]);

            long x = (numberUpto[r] - ((l == 0) ? 0 : (numberUpto[l - 1] * pow10[k] % MOD)) + MOD) % MOD;

            ans[i] = (int)((x*sum)%MOD);
        }

        return ans;



    }
}
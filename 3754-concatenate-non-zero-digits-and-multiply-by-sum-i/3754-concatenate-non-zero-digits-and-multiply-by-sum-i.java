class Solution {
    public long sumAndMultiply(int n) {
        int sum =0;
        int rev=0;
        int x=0;

        while(n!=0){
            int rem = n%10;
            if(rem!=0){
                rev= rev*10 + rem;
                sum= sum+rem;
            }

            n = n/10;
        }

        if(rev==0) return 0;

        while(rev!=0){

            int rem = rev%10;
            x= x*10 + rem;
            rev = rev/10;

        }

        return (long) x*sum;
        
    }
}
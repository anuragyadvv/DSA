class Solution {
    public int totalNumbers(int[] digits) {
        // Brute force 
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        int num =0;

        for(int i=0;i<n; i++){
        
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){

                    if(i==j || j==k ||i==k) continue;


                    num = num*10 + digits[i];
                    num = num*10 + digits[j];
                    num = num*10 + digits[k];

                    

                    if(num%2 ==0  && num>= 100){
                        set.add(num);
                    }

                    num = num/1000;

                }

            }
        }

        return set.size();


        // m-2 

        // HashSet<Integer> set = new HashSet<>();
        // int n= digits.length;
        // int k=3;

        // solve(0,digits,set,k,n, 0);

        // return set.size();
        
    }

    public void solve(int start, int digits[], HashSet<Integer>set, int k, int n, int num){

        if(start>= n || getLen(num)==k ){
            if(num %2 ==0  && getLen(num)==k){
                set.add(num);
                return;
            }
        }

        for(int i=0 ; i<n;i++){
            num = num*10 + digits[i];
            solve(i+1,digits,set,k,n,num);
            num = num/10;
            solve(i+1,digits,set,k,n,num);
        }

    }




    public int getLen(int num ){
        int l = 0;
        while(num !=0){
            l++;
            num = num/10;
        }

        return l;
    }
}
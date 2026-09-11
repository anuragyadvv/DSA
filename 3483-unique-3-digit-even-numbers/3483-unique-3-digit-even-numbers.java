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

                    int len = getLen(num);

                    if(num%2 ==0  && len ==3){
                        set.add(num);
                    }

                    num = num/1000;

                }

            }
        }

        return set.size();
        
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
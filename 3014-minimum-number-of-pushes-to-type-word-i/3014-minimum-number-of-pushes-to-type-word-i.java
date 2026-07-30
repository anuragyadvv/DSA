class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int push =0;
//   we have 8 numbers(2 to 9)
        if(n<= 8){
           return n;
        }
        else if(n>8 && n<=16){
            n= n-8;
            push += 8;
            push += (2*n);
        }
        else if (n>16 && n<= 24){  
           
           n= n-16;
           push += (8 +(2*8));
           push += (3*n);
        }

        else{  // n>24
        n = n-24;
        push += (8+(2*8)+(3*8));
        push += (4*n);

        }

        return push;
        
    }
}
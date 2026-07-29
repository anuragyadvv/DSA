class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        char mid = ' ';
        if(n%2==1){
            mid = s.charAt(n/2);

        }

        int count[] = new int[26];
        for(int i=0;i<n;i++){
             if(n%2==1 && i==n/2) continue; // mid character reserved for middle one 
             count[s.charAt(i)-'a']++;

        }

           //half frequency will be used to build halfResult
           for(int i=0;i<26;i++){
            count[i] /= 2;
           }

           StringBuilder halfResult= new StringBuilder();
           int half = n/2;
           
           for(int i=0 ; i<half ; i++){
            //I am trying to fill ith position
            //What if I could never fill a character in ith position
            boolean placedCharacter =  false;
            for(int j=0;j<26;j++){
                if(count[j]>0){
                    count[j]-=1;

                    // count no of ways 
                    long ways=1;
                    int letters = 0;
                    for(int c=0;c<26;c++){
                        letters += count[c];
                    }

                    for(int c=0; c<26; c++){
                        if(count[c]>0){
                            ways *= nCr(letters, count[c],k);
                            letters-= count[c];
                        }

                        if(ways>= k){
                            break;
                        }
                    }

                    if(ways>= k){//this block contains my kth one
                         halfResult.append((char)(j+'a')); //fixed this character at ith position
                         placedCharacter = true;
                         break;
                    }

                    k -= ways; //when k >= ways
                    count[j]+= 1;
                }
            }

            if(placedCharacter==false){
                return "";
            }

           }
        
        //halfResult + mid + (reverse of halfResult)
        StringBuilder rev = new StringBuilder(halfResult);
        rev.reverse();

        if(mid!=' '){
            halfResult.append(mid);
        }

        return halfResult.toString()+ rev.toString();

        
    }

    long nCr(int n , int r, int k){
        r = Math.min(r,(n-r));
        long result =1;

        for(int i=1;i<=r ; i++){
            result = result * (n-r+i)/i; 

            if(result>=k) return k;
        }
        return result;
    }
}
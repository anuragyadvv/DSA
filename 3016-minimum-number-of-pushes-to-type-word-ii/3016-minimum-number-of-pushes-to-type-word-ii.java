class Solution {
    public int minimumPushes(String word) {
        int minPush =0;
        int count =0;

        Integer freq[] = new Integer[26];
        Arrays.fill(freq,0);
        
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }

        Arrays.sort(freq, Collections.reverseOrder());

        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                count++;
            }else{
                break;
            }
        }

        if(count<= 8){
            for(int i=0;i<=7;i++){
                minPush += freq[i];
            }
        }
        else if(count>8 && count<=16){
            for(int i=0;i<=7;i++){
                minPush += freq[i];
            }
            for(int i=8 ;i<16;i++){
                minPush += (2*freq[i]);
            }
        }

        else if(count>16 && count<=24){
             for(int i=0;i<=7;i++){
                minPush += freq[i];
            }
            for(int i=8 ;i<16;i++){
                minPush += (2*freq[i]);
            }
            for(int i=16;i<24;i++){
                minPush += (3*freq[i]);
            }
        }
        else{ // count>24 and count<=26
            
             for(int i=0;i<=7;i++){
                minPush += freq[i];
            }
            for(int i=8 ;i<16;i++){
                minPush += (2*freq[i]);
            }
            for(int i=16;i<24;i++){
                minPush += (3*freq[i]);
            }
            for(int i=24;i<26;i++){
                minPush += (4*freq[i]);
            }
        }

        return minPush;
        
    }
}
class Solution {
    int maxScore;
    int n;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int freq[] = new int[26];

        maxScore = Integer.MIN_VALUE;
        n = words.length;


        for(char ch : letters){
            freq[ch-'a']++;
        }

        solve(0,score,words,0, freq);

        return maxScore;
    }

    public void solve(int i, int[] score,String[] words, int currScore, int freq[] ){

        maxScore = Math.max(maxScore, currScore);

         if(i>=n){
            return;
         }

        //  can we even take this word[i];
        int j=0;
        int tempScore = 0;
        int tempFreq[] = freq.clone(); 

        while(j<words[i].length()){
            char ch = words[i].charAt(j);
            tempFreq[ch-'a']--;
            tempScore += score[ch-'a'];

            if(tempFreq[ch-'a']<0){
                break;
            }
            j++;
        }

        if(j==words[i].length()){  // we were able to form this word words[i]
            // take option 
            solve(i+1,score, words, currScore + tempScore,tempFreq);
        }

        // not take 
        solve(i+1,score,words,currScore, freq);
    }
}
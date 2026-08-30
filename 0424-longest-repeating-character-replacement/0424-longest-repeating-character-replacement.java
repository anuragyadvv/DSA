class Solution {
    public int characterReplacement(String s, int k) {

        // Appraoch (sliding window ) intution-  character_ needs_to_be_changed = windowLen - maxFreq 

       int n = s.length();

       int freq[] = new int[26];
       int left =0;
       int maxFreq = 0;
       int maxWindow = 0;

       for(int right =0 ;right<n;right++){

        // update the frequency of the current character
        freq[s.charAt(right)-'A']++;

    // update max frequency 
        maxFreq = Math.max(maxFreq, freq[s.charAt(right)-'A']); 

        int windowLen = right-left+1;

        // If windowLen - maxFreq>k
        // then we need to shrink the window 
        if(windowLen-maxFreq > k){
            freq[s.charAt(left)-'A']--;
            left++;
        }

        windowLen = right-left+1;

        maxWindow = Math.max(maxWindow, windowLen);

       }

       return maxWindow;
        
    }
}
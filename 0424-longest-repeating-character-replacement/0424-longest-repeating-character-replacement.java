class Solution {
    public int characterReplacement(String s, int k) {

        // Brute force - O(n2)

        // int n = s.length();
        // int maxLen = 0;

        // for (int i = 0; i < n; i++) {

        //     int freq[] = new int[26];
        //     int maxFreq = 0;
        //     for (int j = i; j < n; j++) {

        //         freq[s.charAt(j) - 'A']++;

        //         maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

        //         int len = j - i + 1;

        //         // not a valid substring  
        //         if ((len - maxFreq) > k) {
        //             break;
        //         } else {
        //             maxLen = Math.max(maxLen, len);
        //         }

        //     }
        // }

        // return maxLen;



        // Appraoch(optimized approach)( tc -O(n)) (sliding window ) intution-  character_ needs_to_be_changed = windowLen - maxFreq 

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

            

            // If windowLen - maxFreq>k  to find windowLen  windowLen = right-left+1;
            // then we need to shrink the window 
            while((right-left+1)-maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

           int  windowLen = right-left+1;

            maxWindow = Math.max(maxWindow, windowLen);

           }

           return maxWindow;

    }
}
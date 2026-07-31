class Solution {
    public int minimumPushes(String word) {
        // little more optimized
        int minPush =0; 
        int freq[] = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);

        for(int i=0;i<26;i++){
            int count = freq[25-i]; // highest frequency first
            if(count==0) break;   // break when frequency become 0 
            // i = 0..7   -> multiplier is (0/8) + 1 = 1
            // i = 8..15  -> multiplier is (8/8) + 1 = 2
            // i = 16..23 -> multiplier is (16/8) + 1 = 3
            // i = 24..25 -> multiplier is (24/8) + 1 = 4

            int multiplier = (i/8)+1;
            minPush += count*multiplier;

        }

        return minPush;
        
    }
}
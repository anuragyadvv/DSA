class Solution {
    String result ="";
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        boolean canUse[] = new boolean[26];
        int reqFreq[] = new int[26]; 
        for(int i=0;i<26;i++){
           
           if(freq[i]>=k){
            canUse[i] = true; 
            reqFreq[i] = freq[i]/k;  // atmost this can be used in a subsequence 
           }
        }

        int maxLen = n/k; // maxLen of a subsequence 
        StringBuilder curr = new StringBuilder();
        backtracking(s,curr, canUse, reqFreq, k , maxLen );

        return result;
        
    }

    public void backtracking(String s, StringBuilder curr, boolean canUse[], int reqFreq[], int k, int maxLen ){

        if(curr.length()>maxLen){
            return;
        }

        String currStr = curr.toString();

        if((curr.length()>result.length() || (curr.length()==result.length()  && currStr.compareTo(result)>0 ))  &&  isSubsequence(s,currStr,k)){
            result = currStr;
        }

        for(int i=25; i>=0; i--){
            if(canUse[i]==false  || reqFreq[i]==0) continue;


        //   Do
            char ch =(char)( i+'a');
            curr.append(ch);
            reqFreq[i]--;

            // explore 
            backtracking(s,curr, canUse, reqFreq, k, maxLen);

            // Undo 
            curr.deleteCharAt(curr.length()-1);
            reqFreq[i]++;
        }
    }

    public boolean isSubsequence(String s , String sub, int k){
        int i=0;
        int j=0;
        int L = sub.length();
        int n = s.length();

        while(i<n && j < k*L){
            if(s.charAt(i)==sub.charAt(j%L)){
                j++;
            }
            i++;
        }

        return j == k*L;
    }
}
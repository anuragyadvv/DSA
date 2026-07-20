class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int lastIndex[] = new int[26];
        Arrays.fill(lastIndex, -1);
        boolean taken[] = new boolean [26];

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            lastIndex[idx] = i;
        }

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';

            if(taken[idx]==true) continue;

            while(sb.length()>0 && sb.charAt(sb.length()-1)>ch && lastIndex[sb.charAt(sb.length()-1)-'a']>i){
                taken[sb.charAt(sb.length()-1)-'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }

            sb.append(ch);
            taken[idx] = true;
        }
        return sb.toString();
        
    }
}
class Solution {
    String result= "";
    public String lexGreaterPermutation(String s, String target) {
          int count [] = new int[26];
          for (char ch : s.toCharArray()){
            count[ch-'a']++;
          }

          StringBuilder sb = new StringBuilder();
          solve(sb, count, target, 0, false);

          return result;
    }

    boolean solve(StringBuilder sb, int count[], String target, int i , boolean greater){
           
           if(i==target.length()){

            if(greater){
                result = sb.toString();
                return true;
            }
            return false;
           } 

           for(char ch ='a' ; ch<='z' ; ch++){
              if(count[ch-'a']==0) continue;

              if(greater==false && ch < target.charAt(i)) continue;

              sb.append(ch);
              count[ch-'a']--;

              boolean isGreater = greater || ch>target.charAt(i); 

              if(solve(sb, count,target,i+1, isGreater)){
                return true;
              }

              sb.deleteCharAt(sb.length()-1);
              count[ch-'a']++;
           }

           return false;
    }
}
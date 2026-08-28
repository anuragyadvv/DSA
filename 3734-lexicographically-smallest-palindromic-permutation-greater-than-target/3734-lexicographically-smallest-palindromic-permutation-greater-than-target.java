class Solution {
    String result ="";
    char midChar ='$';
    int half =0;
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
         int count[] = new int[26];
         for(char ch: s.toCharArray()){
            count[ch-'a']++;
         }

         // Essential Check: If more than 1 character has an odd frequency,
        // no palindrome can ever be formed.
        int oddCount = 0;
        for(int c=0;c<26;c++){
            if(count[c]%2==1){
                oddCount++;
                midChar =(char) (c+'a');

            }
        }

        if(oddCount>1) return ""; // not possible to make a palindrome 
       
    //    for left half of palindrome 
        for(int c=0;c<26; c++){
            count[c] /= 2;

        }

        half= n/2;
       

         StringBuilder sb = new StringBuilder(); // left  half
         solve(sb,count,target,0,false);
         return result;
    }



    public boolean solve(StringBuilder sb ,int count[], String target, int i, boolean greater){
         
        //  base case
        if(sb.length()==half){
            String leftHalf = sb.toString();
            String rightHalf = new StringBuilder(leftHalf).reverse().toString();

            String candidate = leftHalf;

            if(midChar !='$')
            candidate += midChar;
            candidate += rightHalf;

            if (candidate.compareTo(target) > 0) {                   // strictly greater
                result = candidate;
                return true;
            }
            return false;
        }

     
        for(char ch ='a'; ch<='z' ; ch++){

            if(count[ch-'a']==0) continue;

            if(greater==false && ch<target.charAt(i)) continue;

            sb.append(ch);
            count[ch-'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if(solve(sb,count,target,i+1, isGreater)){
                return true;
            }

            sb.deleteCharAt(sb.length()-1);
            count[ch-'a']++;

        }

        return false;
    }

    public boolean isPalindrome( String str){
        char arr[] = str.toCharArray();
        int n = arr.length;

        for(int i=0;i<n/2;i++){
            if(arr[i]!= arr[n-i-1]){
                return false;
            }
        }

        return true;
    }
}
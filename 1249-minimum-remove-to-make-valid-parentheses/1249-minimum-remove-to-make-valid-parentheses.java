class Solution {
    public String minRemoveToMakeValid(String s) {
        // Brute force 
        int countOpeningBracket = 0;
        StringBuilder sb = new StringBuilder();
        int  n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch!='(' && ch !=')'){
                sb.append(ch);
            }

            if(ch =='('){
                sb.append(ch);
                countOpeningBracket++;

            }

            if(ch==')' && countOpeningBracket>0){
                sb.append(ch);
                countOpeningBracket--;

            }
          
        }

        for(int i=sb.length()-1 ; i>=0 && countOpeningBracket > 0 ; i--){
            if(sb.charAt(i)=='('){
                sb.deleteCharAt(i);
                countOpeningBracket--;
                
            }
        }

        return sb.toString();
        
    }
}
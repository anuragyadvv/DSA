class Solution {

    public String removeSubstr(String s, String matchStr){
        StringBuilder sb = new StringBuilder();
        int i=0; // used for writing purpose only  
    
    for(int j=0;j<s.length(); j++){  // j used for reading only 
         sb.append(s.charAt(j));
         i++;

         if(i>1 && sb.charAt(i-2)==matchStr.charAt(0)  && sb.charAt(i-1)==matchStr.charAt(1)){
            sb.delete(i-2,i);
            i-= 2;
         }
    }

    return sb.toString();

    }
    public int maximumGain(String s, int x, int y) {

        // Approach -2 ( without using stack using two pointers one for reading and other for writing )
        int n = s.length();
        int score =0;

        String maxStr = (x>=y)? "ab" : "ba";
        String minStr;
        if(maxStr.equals("ab")){
            minStr = "ba";
        }
        else{
            minStr = "ab";
        }

        // First pass 
        String temp_First = removeSubstr(s,maxStr);
        int L = temp_First.length();

        int charRemoved =(n-L);
        score += (charRemoved/2)*Math.max(x,y);


        // Second Pass 
        String temp_Second = removeSubstr(temp_First, minStr);
        charRemoved = L - temp_Second.length();

        score += (charRemoved/2)*Math.min(x,y); 

        return score ;
        
    }
}
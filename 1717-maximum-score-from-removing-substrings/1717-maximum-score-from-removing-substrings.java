class Solution {

    public String removeSubstr(String s, String matchStr){
        Stack<Character> st = new Stack<>();

        char arr[] = s.toCharArray();

        for(char ch: arr){
            if(ch==matchStr.charAt(1) && !st.isEmpty() && st.peek()== matchStr.charAt(0)){
                st.pop();
            }else{
                st.push(ch);
            }
        }

        StringBuilder temp = new StringBuilder();
        for(char ch : st){
            temp.append(ch);
        }

        return temp.toString();
    }
    public int maximumGain(String s, int x, int y) {

        // Approach -1 (using stack)
        int n = s.length();
        int score =0;

        String maxStr = (x>=y)? "ab" : "ba";
        String minStr = (x<y)? "ab" : "ba";

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
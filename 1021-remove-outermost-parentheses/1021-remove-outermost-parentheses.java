class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                
                st.push(ch);
                if(st.size()>1){
                    sb.append(ch);
                }
                
            }
            else{
                if(st.size()>1){
                    st.pop();
                    sb.append(ch);
                }else{
                    st.pop();
                }
            }
        }

        return sb.toString();

        
    }
}
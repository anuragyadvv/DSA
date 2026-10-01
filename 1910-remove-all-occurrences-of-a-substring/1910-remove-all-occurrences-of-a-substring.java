class Solution {
    public String removeOccurrences(String s, String part) {
        // Using stack 
        int n = s.length();
        int m = part.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
             st.push(s.charAt(i));

            if(st.size()>= m){
                int j= m-1;
                
                while(!st.isEmpty() && j>=0  && st.peek() == part.charAt(j) ){
                    st.pop();
                    j--;
                }
                if(j>=0){ // means all character of s do not   matched part
                j++; 
                while(j<m){
                    st.push(part.charAt(j));
                    j++;
                }
                }
            }

           
        }

        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
        }

        return result.reverse().toString();
        
    }
}
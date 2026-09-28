class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        int n = expression.length();

        for(int i=0;i<n;i++){
            char ch = expression.charAt(i);
            if(ch ==','){
                continue;
            }

            if(ch != ')'){
                st.push(ch);
            }
            else if(ch ==')'){
                Set<Character> set = new HashSet<>();

                while(!st.isEmpty() && st.peek()!= '('){
                    set.add(st.pop());
                }
                st.pop(); // remove opening parenthesis 
                char operator = st.pop(); 

                if(operator == '|'){
                    if(set.contains('t')){
                      st.push('t');
                    }
                    else{
                    st.push('f');
                }
                    
                }


                else if(operator == '&'){

                if(set.contains('f')){
                     st.push('f');
                }
                else{
                    st.push('t');
                }
                   
                }

                 else if(operator == '!' ){
                    if( set.contains('f')){
                      st.push('t');
                    }
                    else{
                    st.push('f');
                }
                }

            }
        }

        if(st.peek()=='t'){
            return true;
        }

        return false;
        
    }
}
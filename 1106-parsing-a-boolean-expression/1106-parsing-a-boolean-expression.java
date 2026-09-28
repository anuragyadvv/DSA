class Solution {
    public boolean parseBoolExpr(String expression) {

        // Approach - put all the characters int the stack till a closing bracket is encountered once a closing bracket is encountered then pop from the stack and add it in a set  till you encounter an opening bracket after coming out of while loop again pop to remove the opening bracket then again pop to get the operator and evaluate the expression based on operator 
         
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
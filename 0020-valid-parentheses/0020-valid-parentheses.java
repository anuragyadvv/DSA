class Solution {
    public boolean isValid(String str) {

//  Approach - When opening brackets are encountered then push them in the stack when a closing bracket is encountered then see the top of stack if it match with closing bracket then pop from the stack .At last if the it is a valid parenthesis the stack will become empty 

     Stack<Character> st = new Stack<>();
     int n = str.length();

     for(int i=0;i<n;i++){
        char ch = str.charAt(i);

        if(ch=='(' || ch=='[' || ch=='{'){ // opening bracket
            st.push(ch);
        }
        else{  //closing bracket

        if(st.isEmpty()){ // means either there is only closing bracket or the first character of string is closing bracket in that case it will not be a valid parenthesis so return false
            return false;
        }

        if((st.peek()=='(' && ch==')') ||(st.peek()=='[' && ch==']') ||(st.peek()=='{' && ch=='}')){
            st.pop();
        }
        else{
            return false;
        }

        }

     }

     if(st.isEmpty()){
        return true;
     }

     return false;
        
    }
}
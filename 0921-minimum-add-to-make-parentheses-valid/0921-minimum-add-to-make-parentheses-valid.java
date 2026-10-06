class Solution {
    public int minAddToMakeValid(String s) {

        // Approach - first we will check if an closing bracket is encounterd and our stack is not empty and its top is a opening bracket in that case it will be a valid parenthesis so we need not to do anything to make it valid because it is valid  so pop from stack otherwise push the character in the stack  , at last stack will contain the number of of invalid parenthesis that we need to balance so that no of parenthesis we require more to balance it  

        // Stack<Character> st = new Stack<>(); // store both opening and closing bracket 
        // for(int i=0;i<s.length();i++){
        //     if(!st.isEmpty() && st.peek()=='(' && s.charAt(i)==')'){ // valid parenthesis so pop this pair 
        //         st.pop();
        //     }
        //     else{
        //         st.push(s.charAt(i));
        //     }
        // }

        // return st.size();


        // Approach -2(constant memory) - when opening bracket is encountered then increase the size by 1 and when closing bracket is encountered and size is grater than zero than decrease the size by 1 (valid pair) and if closing bracket is encountered and size is 0 then increase the count of open by 1  at last return size+open

        int n = s.length();
        int size =0;
        int open =0;

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='('){
                size++;
            }
            else{ // closing bracket 

                if(size>0){
                    size--;
                }else{ // when closing bracket is encountered and size=0
                    open++;
                }
            }
        }

        return size+open;

        
    }
}
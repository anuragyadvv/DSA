class Solution {
    public int minSwaps(String s) {

        // Approach - after removing the balanced parenthesis from the string using stack  then count the no of opening bracket in the stack and observe the pattern it will be (no. of opening bracket+1)/2 ;
        
      Stack<Character> st = new Stack<>(); // store only opening brackets 

      for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='['){
            st.push(s.charAt(i));
        }

        else if(!st.isEmpty() && s.charAt(i)==']' && st.peek()=='['){
            st.pop();
        }

      }

      return (st.size()+1)/2;
        
    }
}
class Solution {
    public int minInsertions(String s) {

        // Brute force 
        int n = s.length();
        Stack<Character> st = new Stack<>();

        int result =0;
        int i=0;

        while(i<n){
            char ch = s.charAt(i);

            if(ch=='('){
              st.push(ch);
              i++;
            }
            else{ // closing bracket

                if( i<n && st.isEmpty() ){
                    int count =0;
                    while( i<n && s.charAt(i)==')'){
                        count++;
                        i++;
                    }
                    result += count/2;
                    if(count %2!=0){
                       result +=2;
                    }
                }
                else{
                    int close = 0;
                    while( i<n  && !st.isEmpty() && s.charAt(i)==')'){
                        close++;
                         i++;
                        
                        if(close==2){
                            st.pop();
                            close =0;
                        }
                       
                    }

                    if(close==1){
                        result++;
                        st.pop();
                    }
                    
                }
            }
        }

         result += st.size()*2; 

        return result;
        
    }
}
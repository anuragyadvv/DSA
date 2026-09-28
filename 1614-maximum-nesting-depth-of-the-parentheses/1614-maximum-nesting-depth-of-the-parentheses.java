class Solution {
    public int maxDepth(String s) {
        // method 1  more optimized 
    //     int maxDepth =0;
    //     int leftParenthesis =0;
        

    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)=='('){
    //             leftParenthesis++;
    //             maxDepth = Math.max(maxDepth,leftParenthesis);
    //         }
    //         else if(s.charAt(i)==')'){
    //              leftParenthesis--;
    //         }
            
    //     }

    //    return maxDepth; 


    // method -2  Using stack when opening bracket push it in stack and size of stack will be depth 

    int maxDepth=0;
    Stack<Character> st = new Stack<>();

    for(int i=0;i<s.length();i++){

        if(s.charAt(i)=='('){
            st.push(s.charAt(i));

            maxDepth = Math.max(maxDepth,st.size());
        }
        else if(s.charAt(i)==')'){
            st.pop();
        }
    }

return maxDepth;

        
    }
}
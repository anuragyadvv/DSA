class Solution {
    public int minimumDeletions(String s) {

    // Appraoch - 1 (using stack)
    int n = s.length();
    int count =0;
    Stack<Character> st = new Stack<>();

    for(int i=0;i<n;i++){
        if( !st.isEmpty() && s.charAt(i)=='a' && st.peek()=='b'){  //means b ke baad a aa gya hai 
        st.pop();
        count++; 
        }
        else{
            st.push(s.charAt(i));
        }
    }

    return count;


        // int res =0;
        // int count =0;

        // for(char c: s.toCharArray()){
        //     if(c=='b'){
        //         count++;
        //     }else if(count!=0){
        //         // a found after b
        //         count--;
        //         res++;
        //     }
        // }
        // return res;
        
    }
}
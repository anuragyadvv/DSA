class Solution {
    public String removeDuplicates(String s) {

        // Brute force 
        // StringBuilder sb = new StringBuilder(s);
        // boolean hasDuplicate = true;

        // while(hasDuplicate){
        //     hasDuplicate= false;

        //     for(int i=0;i<sb.length()-1;i++){

        //         if(sb.charAt(i)==sb.charAt(i+1)){
        //             sb.delete(i,i+2);
        //             hasDuplicate = true;
        //             break;
        //         }
        //     }
        // }

        // return sb.toString();


        // Using stack 

        char arr[] = s.toCharArray();

         StringBuilder sb = new StringBuilder();

        Stack<Integer> st= new Stack<>();  // store indices 
        st.push(0); // push 0th index because first element is always unique 

        for(int i=1;i<s.length();i++){
            char ch = arr[i];

            if(!st.isEmpty() && arr[st.peek()]==ch){
                st.pop();
            }
            else{
                st.push(i);
            }
        }



        if(st.isEmpty()){  // means all duplicates 
            return "";
        }

        else{
            while(!st.isEmpty()){
                sb.append(arr[st.pop()]);
            }
        }

     return sb.reverse().toString(); 
    }
}
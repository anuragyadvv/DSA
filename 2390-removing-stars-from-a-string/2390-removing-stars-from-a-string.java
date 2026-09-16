class Solution {
    public String removeStars(String s) {

        // Brute force -O(n2)
        
        // StringBuilder sb = new StringBuilder(s);
        // int i = 0;
        // while (i < sb.length()-1) {

        //     if (sb.charAt(i + 1) == '*') {
        //         sb.delete(i, i + 2);

        //         if (i > 0) {
        //             i = i - 1;
        //         }

        //     } else {
        //         i++;
        //     }

        // }

        // return sb.toString();

     
    //  Approach - 3 (Using two pointers )

    int n = s.length();
    char arr[] = new char[n];
    int i=0;
    int j =0;

    while(i<n){
        char ch = s.charAt(i);
        if(ch != '*'){
           arr[j] = ch;
           j++;
        }
        else{
            j--;
        }
        i++;
    }



    return new String(arr,0,j);



        //Approach -3  using stack (when character then push in stack when star than pop from stack at last make string from remaining stack reverse it and return )

        // int n = s.length();
        // Stack<Character> st = new Stack<>();

        // for (int i = 0; i < n; i++) {
        //     char ch = s.charAt(i);

        //     if (ch == '*') {
        //         st.pop();
        //     } else {
        //         st.push(ch);
        //     }
        // }

        // StringBuilder sb = new StringBuilder();
        // while (!st.isEmpty()) {
        //     sb.append(st.pop());
        // }

        // return sb.reverse().toString();

    }
}
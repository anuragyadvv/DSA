class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch != ')') { // then push means push character and opening brackets 
                st.push(ch);
            }

            else if (ch == ')') {
                StringBuilder sb = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                for (int j = 0; j < sb.length(); j++) {
                    st.push(sb.charAt(j));
                }

            }

        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();

    }
}
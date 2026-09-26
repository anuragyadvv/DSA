class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Brute Force 
        
        int n = s.length();

        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);
            if(ch != ')'){
                st.push(ch);
            }

            else if(ch==')'){
                StringBuilder sb = new StringBuilder();

                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }

                st.pop(); // remove the opening bracket 

                String key = sb.reverse().toString();
                if(map.containsKey(key)){
                    String value = map.get(key);
                    for(int j=0;j<value.length();j++){
                        st.push(value.charAt(j));
                    }
                }else{ // key not present in map 
                char c ='?';
                   st.push(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
        }

        return result.reverse().toString();


        
    }
}
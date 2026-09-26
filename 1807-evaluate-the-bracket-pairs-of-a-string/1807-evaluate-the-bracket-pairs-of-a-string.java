class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Brute Force (Stack approach) Approach - first put all the key value pair in a map for easy access then iterate on string and  push all the characters of string in stack until  a closing bracket is encountered , Once a closing brcket is encountered make a StringBuilder sb and pop from stack and add to stringbuilder until an opening bracket is encountered once an opening brcaket is encountered come out of loop and again pop to remove the opening bracket from the stack , Now reverse the stringbuilder and convert it to string naming it key and now check if the map contains that key if it contains the key then find value of that key and push each character of that value String in the stack , And if the key does not exist in the map then push a '?' in the stack  , Now after iterating the whole string come out of the first for loop and now store all the charcters of the stack in a stringbuilder result , then reverse the stringbuilder and convert it to string and return it . 
        
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
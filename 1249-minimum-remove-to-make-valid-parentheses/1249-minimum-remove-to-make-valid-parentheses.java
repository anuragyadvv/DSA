class Solution {
    public String minRemoveToMakeValid(String s) {
        // Brute force 
        // int countOpeningBracket = 0;
        // StringBuilder sb = new StringBuilder();
        // int  n = s.length();
        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);

        //     if(ch!='(' && ch !=')'){
        //         sb.append(ch);
        //     }

        //     if(ch =='('){
        //         sb.append(ch);
        //         countOpeningBracket++;

        //     }

        //     if(ch==')' && countOpeningBracket>0){
        //         sb.append(ch);
        //         countOpeningBracket--;

        //     }
          
        // }

        // for(int i=sb.length()-1 ; i>=0 && countOpeningBracket > 0 ; i--){
        //     if(sb.charAt(i)=='('){
        //         sb.deleteCharAt(i);
        //         countOpeningBracket--;
                
        //     }
        // }

        // return sb.toString();


        // Approach -2 (Using stack)
        int n = s.length();
        Stack<Integer> st = new Stack<>(); // store indices where open bracket is present 
        Set<Integer> set = new HashSet<>();

        StringBuilder result = new StringBuilder(); 

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch !='(' && ch != ')'){
                continue ;
            }
            else if(ch=='('){
                st.push(i);
            }
            else if(ch==')'){
                if(st.isEmpty()){
                    set.add(i);  // extra closing bracket that need to be removed
                }
                else{
                   st.pop();
                }
                
            }

        }

        //    only opening brackets that we need to remove 
            while(!st.isEmpty()){
                set.add(st.pop());  // adding in set so we can eaisly access 
            }

            for(int i=0;i<n;i++){
                if(set.contains(i)) continue;

                result.append(s.charAt(i));
            }
 
        

        return result.toString();

        
    }
}
class Solution {
    public int calculate(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();

        Stack<Integer> st = new Stack<>();

        int number =0;
        int result = 0;
         int sign = 1; // 1 denotes positive  and -1 denotes neagtive symbol initially 1 

         for (int i=0;i<n;i++){

            if(Character.isDigit(arr[i])){

                number = number*10 + (arr[i]-'0'); // number banate chalo 

            }
            else if(arr[i]=='+'){
                  // number ban chuka hoga 
                //   result main add kro
                result += (number*sign);
                number = 0;
                sign = 1;
            
            }
            else if(arr[i]=='-'){
                   // number ban chuka hoga 
                //   result main add kro
                result += (number*sign);
                number = 0;
                sign = -1;


            }
            else if(arr[i]=='('){ // open bracket 

            st.push(result);
            st.push(sign);

            number =0;
            result =0;
            sign =1;


            }
            else if(arr[i]==')'){
                // bracket ke andar ke cheezo ko solve kr le pahele 
                result += (number*sign);
                number =0;

                int stack_sign = st.pop();
                int last_result = st.pop();

                result *= stack_sign;
                result += last_result; 

            }


         }
         result += (number*sign);  // last wale number ke baad string khatam ho jaayegi isliye isko last main jodna hoga jo bhi number ki value hogi
         return result;

        
    }
} 
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++){
            String token = tokens[i];



            if(token.equals("+") || token.equals("-") ||  token.equals("*")  ||  token.equals("/")){

                 int num2 = s.pop();
                 int num1 = s.pop();

                if(token.equals("+")){

                    s.push(num1+num2);
                }

                else if(token.equals("-")){
                    s.push(num1-num2);
                }

                else if(token.equals("*")){
            
                    s.push(num1*num2);
                }

                else{
                    s.push(num1/num2);
                }
            }

            else{  // means it will be a digit 

             s.push(Integer.parseInt(token));

            }

        }

        return s.pop();
        
    }
}
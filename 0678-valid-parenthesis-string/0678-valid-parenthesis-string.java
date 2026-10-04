class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int open =0;
        int close =0;
        int star =0;

//  left to right traversal 
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
            }else if(s.charAt(i)=='*'){
                star++;
            }
            else{ // closing bracket 
              close++;

              if(close>open+star){
                return false;
              }

            }
        }


        open =0;
        close =0;
        star=0;
    // right to left traversal 
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')'){
                close++;
            }else if(s.charAt(i)=='*'){
                star++;
            }
            else{ // opening bracket 
            open++;
            if(open>close+star){
                return false;
            }

            }
        }

       

        return true;
        
    }
}
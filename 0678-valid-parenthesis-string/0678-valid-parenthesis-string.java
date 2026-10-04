class Solution {
    public boolean checkValidString(String s) {

        // Recursion and memoization 
        int n = s.length();
        int t[][] = new int[n][n];

        for(int arr[]: t){
            Arrays.fill(arr,-1);
        }
        return solve(s,0,0,t);
        
    }

    public boolean solve(String s,int i, int open, int t[][]){

        if(i>=s.length()){
            if(open==0){
                return true;
            }
            return false;
        }

        if(t[i][open] != -1){
            return t[i][open]==1;
        }

        boolean isValid = false;

        if(s.charAt(i)=='('){
            isValid = solve(s,i+1,open+1,t);
        }
        else if(s.charAt(i)=='*'){
            isValid |= solve(s,i+1,open+1,t);
            isValid |= solve(s,i+1,open,t);
            if(open>0){
                isValid |= solve(s,i+1,open-1,t);
            }
        }
        else if(open>0){
            isValid |= solve(s,i+1,open-1,t);
        }

         t[i][open] = isValid? 1:0;
         return isValid;
    }
}
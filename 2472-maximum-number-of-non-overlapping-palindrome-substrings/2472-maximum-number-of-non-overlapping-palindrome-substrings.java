class Solution {
    public int maxPalindromes(String s, int k) {

        
        int n = s.length();

        if(k==1){
            return n;
        }

        int t[][] = new int[n+1][n+1];
        for(int arr[] : t){
            Arrays.fill(arr,-1);
        }

        return solve(s,k,0,k-1,n, t);
        
    }

    public int solve(String s, int k, int i, int j,int n, int t[][]){

        if(i>= n || j>=n){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(isPalindrome(s,i,j)){

            int take = 1+ solve(s,k,j+1,j+k,n,t);
            int grow = solve(s,k,i,j+1,n,t);
            int slide = solve(s,k,i+1,j+1,n,t);

            return t[i][j] =  Math.max(take, Math.max(grow,slide));
        }
        else{ // not a palindrome 
           
           int grow = solve(s,k,i,j+1,n,t);
           int slide = solve(s,k,i+1,j+1,n,t);

           return t[i][j] = Math.max(grow,slide);

        }
    }

    public boolean isPalindrome(String s, int i , int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
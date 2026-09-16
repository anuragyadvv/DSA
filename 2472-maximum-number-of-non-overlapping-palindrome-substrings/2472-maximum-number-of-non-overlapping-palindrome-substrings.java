class Solution {
    public int maxPalindromes(String s, int k) {
        //Bottom up 
        int n = s.length();

        if (k == 1) {
            return n;
        }

        int t[][] = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (isPalindrome(s, i, j)) {
                    int takeIt = 1 + (j + k <= n ? t[j + 1][j + k] : 0);
                    int grow = t[i][j + 1];
                    int slide = t[i + 1][j + 1];

                    t[i][j] = Math.max(takeIt, Math.max(grow,slide));

                }
                else{
                    int grow = t[i][j+1];
                    int slide = t[i+1][j+1];

                    t[i][j] = Math.max(grow,slide);
                }
            }
        }

        return t[0][k-1];

    }

    public boolean isPalindrome(String s, int i, int j){

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
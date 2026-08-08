class Solution {
    int result;
    int n;
    public int distributeCookies(int[] cookies, int k) {
         result = Integer.MAX_VALUE;
         n = cookies.length;
         int children[] = new int[k];
         solve(cookies,0,children,k);

         return result;
    }

    public void solve(int cookies[],int idx,int children[],int k){

        if(idx>=n){
            int unfairness = Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                unfairness = Math.max(unfairness,children[i]);
            }

            result = Math.min(result,unfairness);
            return;
        }

        int cookie = cookies[idx]; // cookies to give
        for(int i=0;i<k;i++){  // to give to which children

        children[i] += cookie; // given cookie to ith children 
        solve(cookies,idx+1,children,k);

        children[i] -= cookie; // backtracking statement

        }
    }
}
class Solution {
    int result;
    public int maximumRequests(int n, int[][] requests) {
        int resultant[] = new int [n];
        result =0;
        solve(0,0,resultant,requests);
        return result;

        
    }
    public void solve(int idx,int count, int resultant[], int requests[][]){

        // base case 
        if(idx>= requests.length){
           boolean isSumZero = true;
            for(int i=0;i<resultant.length;i++){
                if(resultant[i]!=0){
                    isSumZero = false;
                }
            }
            if(isSumZero){
                result = Math.max(result,count);
                return;
            }
            return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];

        // do
        resultant[from]--;
        resultant[to]++;

        // explore choices after request accepted
        solve(idx+1,count+1,resultant,requests);

        // undone 
        resultant[from]++;
        resultant[to]--;
       
       //explore choice after request rejected 
        solve(idx+1,count,resultant,requests);
    }
}
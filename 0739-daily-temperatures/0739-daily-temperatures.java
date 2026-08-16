class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s= new Stack<>();
        int ans[] = new int [n];
        ans[n-1] = 0;
        s.push(n-1);
       
       for(int i=n-2;i>=0 ;i--){
           
           int curr = temperatures[i];

           while(!s.isEmpty() && temperatures[s.peek()]<=curr){
                 s.pop();
        }
        if(s.isEmpty()){
            ans[i]=0;
        }
        else{
            ans[i] = s.peek() - i;
        }

        s.push(i);
       }
        
       return ans; 
    }
}
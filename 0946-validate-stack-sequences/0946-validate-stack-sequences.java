class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();

        int n = pushed.length;

        int i=0;
        int j =0;

        while(i<n && j<n){
            s.push(pushed[i]);

            while(!s.isEmpty() && j<n && popped[j]==s.peek()){
                s.pop();
                j++;
            }

            i++;
        }

        if(s.isEmpty()){
            return true;
        }

        return false;
        
    }
}
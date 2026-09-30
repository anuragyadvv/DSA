class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        // Intution- divide seq into half means half opening and closing bracket in one and the other half opening and closing brcaket in other 

        int n = seq.length();
        int result[] = new int[n];

        int depth = 0;
        for(int i=0;i<n;i++){
            char ch = seq.charAt(i);

            if(ch=='('){
                depth++;
                if(depth %2 != 0){ // odd
                    result[i] = 1;
                }
                else{ // even 
                 result[i] = 0;
                }
            }
            else{ // closing bracket 
            result[i]= (depth % 2==0)? 0 : 1;
            depth--;

            }
        }

        return result;
        
    }
}
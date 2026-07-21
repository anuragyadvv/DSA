class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // count existing 1 
        int existingCount = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                 existingCount++;
            }
        }

        //find zeroBlocks 
        ArrayList<Integer> list = new ArrayList<>();
       int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                int start = i;
                while(i<n && s.charAt(i)=='0'){
                    i++;
                }
                list.add(i-start);
            }
               i++;
             
        }

        // calculate maxPair sum 
        int maxPairSum =0;
        for(int j=0;j<list.size()-1;j++){
            maxPairSum= Math.max(maxPairSum,(list.get(j)+list.get(j+1)));
        }

        return (existingCount+maxPairSum);
        
    }
}
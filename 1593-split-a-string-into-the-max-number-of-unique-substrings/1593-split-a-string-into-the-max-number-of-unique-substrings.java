class Solution {
    public int maxUniqueSplit(String s) {

        Set<String> set = new HashSet<>();
        int maxCount[] = new int[1];
        int currCount = 0;
        int i =0;
        solve(s,i, set, currCount,maxCount);

        return maxCount[0];

        
    }

    public void solve(String s, int i , Set<String>set ,int currCount, int maxCount[]){

        // pruning
          if(currCount +(s.length()-i) <=  maxCount[0]){
            return;
          }



        //   base case 
           if(i>= s.length()){
            maxCount[0] = Math.max(maxCount[0], currCount);
            return ;
           }

           for(int j= i; j<s.length();j++){
             String sub = s.substring(i,j+1);
             if(!set.contains(sub)){
                set.add(sub); // do 
                solve(s,j+1,set,currCount+1, maxCount); // explore 
                set.remove(sub);  // undo 

             }
           }
    }
}
class Solution {

    private static final double  EPSILON = 0.1;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();

        for(int card: cards){
            nums.add((double) card);
        }

        return solve(nums);
        
    }

    private boolean solve(List<Double>cards){
        if(cards.size()==1){
            return Math.abs(cards.get(0)-24) <= EPSILON;
        }
    
    // pick two possible numbers 
        for(int i=0;i<cards.size();i++){
            for(int j=0;j<cards.size(); j++){
                if(i==j) continue;
            
               
                List<Double> temp = new ArrayList<>();  // to add remaining number of cards  
                for(int k=0; k<cards.size();k++){
                    if(k!=i && k !=j){
                        temp.add(cards.get(k));
                    }
                }

                 double a = cards.get(i);
                double b = cards.get(j);

                // store the posiible values for all the operation 
                List<Double> possibleVals = new ArrayList<>();
                possibleVals.add(a+b);
                possibleVals.add(a-b);
                possibleVals.add(b-a);
                possibleVals.add(a*b);

                if(Math.abs(b)>0.0){ // if b = 0 then it will be infinity (can ignore because range starts from 1 to 9)
                    possibleVals.add(a/b);
                }

                 if(Math.abs(a)>0.0){ // if a = 0 then it will be infinity (can ignore because range starts from 1 to 9)
                    possibleVals.add(b/a);
                }

                for(double val : possibleVals){

                    temp.add(val);  // do

                    if(solve(temp)){   // explore 
                        return true;
                    }

                    temp.remove(temp.size()-1);  // undo 

                }



            }
        }

        return false;
    }
}
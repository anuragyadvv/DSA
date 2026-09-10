class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
     List<List<Integer>> res = new ArrayList<>();
     makeCombination(candidates,target,0, new ArrayList<>(),res);
     return res;

        
    }

    public void makeCombination(int candidates[],int target,int start, List<Integer> comb, List<List<Integer>> res ){

      if (target<0){
        return;
      }

      if(target==0){
        res.add(new ArrayList<Integer>(comb));
        return;
      }

      for(int i=start;i<candidates.length;i++){

        if(i>start && candidates[i]==candidates[i-1]){
            continue;
        }
        if (candidates[i]>target){
            break;
        }

        comb.add(candidates[i]); // take

        makeCombination(candidates,target-candidates[i],i+1,comb,res);  // explore 

        comb.remove(comb.size()-1); // undo 
      }

    }
}
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(1,n,k,list,result);
        return result;

        
    }

    public void backTrack(int start, int n , int k, List<Integer> list, List<List<Integer>>result){


       if(k==0){
        result.add(new ArrayList<>(list));
        return;
       }

           if(start>n){
            return;
        }

        list.add(start);
        backTrack(start+1,n,k-1,list,result);
        list.remove(list.size()-1);
        backTrack(start+1,n,k,list,result);
    }
}
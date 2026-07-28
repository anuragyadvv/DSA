class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n  = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer>map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        solve(map,list,res,n);

        return res;
        
    }

    public void solve(Map<Integer,Integer>map, List<Integer>list, List<List<Integer>> res, int n){
        //  base case
           if(list.size()==n){
                res.add(new ArrayList<>(list));
                return;
            }


        for(Integer key: map.keySet()){

            if(map.get(key)==0) continue;

        // Backtracking steps
        // DO
            list.add(key);
            map.put(key, map.get(key)-1);

            // Trust or explore 
            solve(map,list,res,n);

            // undo 
            list.remove(list.size()-1);
            map.put(key, map.getOrDefault(key,0)+1);
        }
    }
}
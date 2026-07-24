class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean hasPair[] = new boolean[2048];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                int val = (nums[i]^nums[j]);
                if(!hasPair[val]){
                    hasPair[val] = true;
                   list.add(val);
                }
                
                    
                
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<list.size();j++){
                set.add((nums[i]^list.get(j)));
            }
        }

        return set.size();

        
        
    }
}
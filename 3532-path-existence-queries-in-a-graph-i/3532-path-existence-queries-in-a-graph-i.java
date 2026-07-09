class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q = queries.length;
        boolean res[] = new boolean[q];
        int component[] = new int[nums.length];


// similar concept to union sum 
        component[0]=0;
        for(int i=1 ;i<nums.length ; i++){
            int diff = Math.abs(nums[i]-nums[i-1]);

            if(diff<=maxDiff){
                component[i]= component[i-1];
            }else{
                component[i]= i;
            }
        }

        for(int i=0;i<q;i++){
            int node1 = queries[i][0];
            int node2 = queries[i][1];

           if(component[node1]==component[node2]){
            res[i] = true;
           }
        }

        return res;
        
    }
}
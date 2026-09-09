class Solution {
    int n ;
    int minSum = Integer.MAX_VALUE;
    int result[];

    public int[] findPermutation(int[] nums) {
        n = nums.length;
        boolean visited[] = new boolean[n];
        List<Integer> temp = new ArrayList<>();

        // Permutations are cyclic; to make it lexicographically smallest, always start at 0
        temp.add(0);
        visited[0] = true;
        solve(nums,visited,temp,0);
        return result;
    }


    public void solve(int nums[], boolean visited[],List<Integer>temp, int score){
        if(minSum <= score) return;

        if(temp.size()==n){
            score += Math.abs(temp.get(temp.size()-1) - nums[temp.get(0)]);

            if(score < minSum){
                minSum = score;
                result = new int[n];
                for(int i=0;i<n;i++){
                    result[i] = temp.get(i);
                }
            }
            return;
        }


        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(i);
                int cost = Math.abs(temp.get(temp.size()-2) - nums[temp.get(temp.size()-1)]);

                solve(nums,visited,temp, score+cost);

                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
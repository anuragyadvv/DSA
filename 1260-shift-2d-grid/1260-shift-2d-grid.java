class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length; // row
        int n = grid[0].length; // col

        List<List<Integer>> ans = new ArrayList<>();
       
    //    prefill the 2d list with dummy value 
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(0);
            }
            ans.add(row);
        }

            for(int i=0;i<m;i++){ // row 
                for(int j=0;j<n;j++){ // col

                    int oneDIndex = ((i*n+j)+k) %(m*n);
                    int newr = oneDIndex/n;
                    int newc = oneDIndex % n;

                    ans.get(newr).set(newc,grid[i][j]);
                }
            }

        return ans;
        
    }
}
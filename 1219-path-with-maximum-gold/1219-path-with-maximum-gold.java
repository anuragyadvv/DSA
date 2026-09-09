class Solution {
    int maxGold = Integer.MIN_VALUE;
    int m ;
    int n ;
    public int getMaximumGold(int[][] grid) {
         m = grid.length;
         n = grid[0].length;

         boolean visited[][] = new boolean[m][n];

         for(int i=0 ; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] !=0){
                    solve(grid, visited,i,j, 0);
                }
            }
         }

        return (maxGold ==Integer.MIN_VALUE)? 0 : maxGold;

        
    }

    public void solve(int grid[][], boolean visited[][], int i, int j, int res){
           
           if(!visited[i][j]){

            res += grid[i][j];
            maxGold = Math.max(maxGold,res);
            visited[i][j] = true;

            // explore (choices)
            if(i+1<m && grid[i+1][j] != 0){
                solve(grid,visited,i+1,j,res);
            }

             if(i-1>=0 && grid[i-1][j] != 0){
                solve(grid,visited,i-1,j,res);
            }

            if(j-1>=0 && grid[i][j-1] !=0){
                solve(grid,visited,i,j-1, res);
            }

            if(j+1<n && grid[i][j+1] != 0){
                solve(grid,visited,i,j+1,res);
            }

            // backtrack 
            res -= grid[i][j];
            visited[i][j] = false;

           }
    }
}
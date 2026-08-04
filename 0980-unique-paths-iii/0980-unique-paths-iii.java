class Solution {
    int m,n;
    int result;
    int nonObstacles;
    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public int uniquePathsIII(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        result =0;
        nonObstacles=0;
        int start_x=0;
        int start_y=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    nonObstacles++;
                }

                if(grid[i][j]==1){
                    start_x =i;
                    start_y = j;
                }
            }
        }

        nonObstacles += 1;

        int count =0;
        backtrack(grid,count, start_x,start_y);
        return result;
        
    }

    public void backtrack(int[][] grid,int count, int i,int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]== -1 ){
            return;
        }

        if(grid[i][j]==2){
            if(count==nonObstacles){
                result += 1;
            }
            return;
        }

        grid[i][j]=-1;

        for(int dir[]: directions){
            int newi = i+dir[0];
            int newj = j+dir[1];

            backtrack(grid,count+1, newi,newj);
        }
        
        grid[i][j] = 0; // backtrack statement
    }
}
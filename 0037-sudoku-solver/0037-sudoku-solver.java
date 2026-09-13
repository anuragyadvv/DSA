class Solution {
    public void solveSudoku(char[][] board) {

        solve(board);
        
    }

    public boolean solve(char [][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){


                if(board[i][j]=='.'){

                    for(char d='1' ; d<='9' ;d++){
                        if(isSafe(board, i,j, d)){

                            board[i][j] = d; // do 

                            if(solve(board)==true){  // explore 
                                return true;
                            }
                            
                            board[i][j] = '.'; // undo 
                        }
                        
                    }

                    return false;
                }
            }
        }

        return true ; // means there is no dot  
    }

    public boolean isSafe(char board[][], int row, int col, char val){

        // check row and column 
        for(int i=0;i<9;i++){
            //   row condition 
            if(board[row][i]== val){
                return false;
            }
          
        //   col condition 
            if(board[i][col]==val){
                return false;
            }
        }


        //  grid condition 
        int start_row = (row/3)*3;
        int start_col = (col/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(board[start_row+i][start_col+j]== val){
                    return false;
                }
            }
        }

        return true;
    }
}
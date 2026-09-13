class Solution {
    public int largestOverlap(int[][] A, int[][] B) {

        int n = A.length;  // square matrix

        int maxOverlap = 0;

        for(int rowOffset = -n+1 ; rowOffset<n ; rowOffset++){
            for(int colOffset = -n+1; colOffset<n; colOffset++){

                int count = countOverlaps(A, B, rowOffset, colOffset);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
         
    }

    public int countOverlaps(int A[][], int B[][], int rowOffset, int colOffset){
        int n = A.length;
        int count =0;

        for(int i=0 ; i<n;i++){
            for(int j=0;j<n;j++){
                // find indices of B from A ka indices 
                // A[i][j] -> B[i+rowOffset][j+colOffset]

                int B_i = i+rowOffset;
                int B_j = j+colOffset;

                if(B_i < 0 || B_i>=n ||B_j < 0 || B_j >=n ){
                    continue;
                }

                if(A[i][j] == 1 && B[B_i][B_j]==1) count++;

            }
        }

        return count;
    }
}
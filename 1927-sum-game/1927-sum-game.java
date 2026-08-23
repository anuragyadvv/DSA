class Solution {
    public boolean sumGame(String num) {
        int n= num.length();
        int leftKnownSum =0;
        int rightKnownSum = 0;

        int leftQnMarkCount = 0;
        int rightQnMarkCount = 0;

        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2){
                    leftQnMarkCount++;
                }else{
                  rightQnMarkCount++;  
                }
            }
            else{
                if(i<n/2){
                    leftKnownSum += num.charAt(i)-'0';
                }
                else{
                    rightKnownSum += num.charAt(i)-'0';
                }
            }
        }

        int totalQnMarks = leftQnMarkCount + rightQnMarkCount;

        if(totalQnMarks %2 != 0){ // odd then alice always win 
            return true ;
        }

        int Left = 2*leftKnownSum + 9*leftQnMarkCount;
        int Right = 2*rightKnownSum + 9 *rightQnMarkCount;

        return Left!=Right;  // Alice win 
        
    }
}
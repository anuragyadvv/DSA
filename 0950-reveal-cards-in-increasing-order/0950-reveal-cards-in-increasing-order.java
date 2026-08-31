class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        // appraoch -1 
        int n =deck.length;
        Arrays.sort(deck);
        
        int result[] = new int[n];

        boolean skip = false;

        int i=0; // for deck traversal
        int j=0; // for result traversal

        while(i<n){

            if(result[j]==0){ // khali hai
               
               if(skip==false){
                result[j] = deck[i];
                i++;
                
               }

               skip = !skip; // alternate 
            }

            j=(j+1)%n;
        }

        return result;
        
    }
}
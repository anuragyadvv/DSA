class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        // appraoch -1 - nlogn
        // int n =deck.length;
        // Arrays.sort(deck);

        // int result[] = new int[n];

        // boolean skip = false;

        // int i=0; // for deck traversal
        // int j=0; // for result traversal

        // while(i<n){

        //     if(result[j]==0){ // khali hai
               
        //        if(skip==false){
        //         result[j] = deck[i];
        //         i++;
                
        //        }

        //        skip = !skip; // alternate 
        //     }

        //     j=(j+1)%n;
        // }

        // return result;


        // Aproach -2  nlogn

        int n = deck.length;

        Arrays.sort(deck);

        int result[] = new int[n];
        Queue<Integer> q = new LinkedList<>();

        // push all the indices in the queue these indices are used for result 
        for(int i=0;i<n;i++){
            q.add(i);
        }

        int i = 0;
        while(i<n){
            result[q.remove()] = deck[i];
            i++;
          
           if(!q.isEmpty())
            q.add(q.remove());
        }

        return result;
        
    }
}
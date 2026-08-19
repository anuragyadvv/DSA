class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       // more space optimization using bit manipulation 
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int reservedSeat[]:reservedSeats){
          int row = reservedSeat[0];
          int seat = reservedSeat[1];
          map.merge(row,(1<<seat),(a,b)-> a|b); // set bits are the booked bits 
       } 

       int result =(n-map.size())*2;

       int maskA = (1<<2)|(1<<3)|(1<<4)|(1<<5);//set bits are the ones I need empty for Group A
       int maskB = (1<<4)|(1<<5)|(1<<6)|(1<<7);//set bits are the ones I need empty for Group B
       int maskC = (1<<6)|(1<<7)|(1<<8)|(1<<9);//set bits are the ones I need empty for Group C 

       for(Map.Entry<Integer,Integer>entry: map.entrySet()){
        int bookedSeatsMask = entry.getValue();

        boolean groupA = (bookedSeatsMask & maskA)==0;
        boolean groupB = (bookedSeatsMask & maskB)==0;
        boolean groupC = (bookedSeatsMask & maskC)==0;

        if(groupA && groupC) result +=2;
        else if(groupA ||groupB || groupC) result +=1;
       }
       return result;  
    }
}
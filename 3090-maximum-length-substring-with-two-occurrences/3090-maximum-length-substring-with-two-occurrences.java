class Solution {
    //a little optimized  
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
       

        for(int i=0;i<n;i++){
             HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
               
               if(map.get(s.charAt(j))>2){
                break;
               }

               maxLength = Math.max(maxLength,j-i+1);
        
            }
        }

        return maxLength;

    }
}
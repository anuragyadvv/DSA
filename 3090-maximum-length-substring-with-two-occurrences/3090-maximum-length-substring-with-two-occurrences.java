class Solution {
    // Brute force 
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
       

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
              HashMap<Character,Integer> map = new HashMap<>();
              for(int k=i;k<=j;k++){
                map.put(s.charAt(k),map.getOrDefault(s.charAt(k),0)+1);
              }
              boolean isMaxFreqLessThanTwo = true;
              for(Character key: map.keySet()){
                if(map.get(key)>2) isMaxFreqLessThanTwo = false;
              }

              if(isMaxFreqLessThanTwo){
                maxLength = Math.max(maxLength,j-i+1);
              }
            }
        }

        return maxLength;

    }
}
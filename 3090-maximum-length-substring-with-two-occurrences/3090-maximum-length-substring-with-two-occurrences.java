class Solution {
    //optimized  (similar to leetcode 3 (Longest substring without reptiting character)
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
         HashMap<Character,Integer> map = new HashMap<>();
       
          int l=0;
        for(int r=0;r<n;r++){
            char key = s.charAt(r);
            map.put(key, map.getOrDefault(key,0)+1);

            while(map.get(key)>2){
                char left = s.charAt(l);
                map.put(left,map.get(left)-1);
                l++;
            }

               maxLength = Math.max(maxLength,r-l+1);
        
            }
        

        return maxLength;

    }
}
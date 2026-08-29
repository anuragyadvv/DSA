class Solution {
    
    public int maximumLengthSubstring(String s) {


        // Brute force 
        char arr[] = s.toCharArray();
        int n= arr.length;

        int maxLen = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            HashMap<Character, Integer> map = new HashMap<>(); // store character and its frequecy
            for(int j=i;j<n;j++){
                char key = arr[j];
                map.put(key,map.getOrDefault(key,0)+1);

                if(map.containsKey(key) && map.get(key)>2){
                    break;
                }

                maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;



        //optimized(Sliding window khandani approach)  (similar to leetcode 3 (Longest substring without reptiting character)

        // int n = s.length();
        // int maxLength = Integer.MIN_VALUE;
        //  HashMap<Character,Integer> map = new HashMap<>();
       
        //   int l=0;
        // for(int r=0;r<n;r++){
        //     char key = s.charAt(r);
        //     map.put(key, map.getOrDefault(key,0)+1);

        //     while(map.get(key)>2){
        //         char left = s.charAt(l);
        //         map.put(left,map.get(left)-1);
        //         l++;
        //     }

        //        maxLength = Math.max(maxLength,r-l+1);
        
        //     }
        

        // return maxLength;

    }
}
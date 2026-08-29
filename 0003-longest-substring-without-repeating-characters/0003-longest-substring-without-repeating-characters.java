class Solution {
    public int lengthOfLongestSubstring(String s) {
    
    //  Brute force - O(n3)
//     char arr[] = s.toCharArray();
//     int n = arr.length;
//     int maxLen = 0;

//     for(int i=0;i< n;i++){
//         StringBuilder sb = new StringBuilder();
//         for(int j=i;j<n;j++){
//            sb.append(arr[j]);
//            String str = sb.toString();
//            boolean containsDuplicate = false;
//            Set<Character> set = new HashSet<>();
//            for(int k=0;k<str.length();k++){
//               char ch = str.charAt(k);
//               if(set.contains(ch)){
//                 containsDuplicate = true;
//                 break;
//               }else{
//                 set.add(ch);
//               }
//            }

//            if(containsDuplicate == false){
//              maxLen = Math.max(maxLen, j-i+1);
//            }

           
//         }
//     }

//    return maxLen;


//     Brute force - O(n2)

  char arr[] = s.toCharArray();
  int n = arr.length;
  int maxLen =0;

   for(int i=0;i<n;i++){
    Set<Character> set = new HashSet<>();
    for(int j=i;j<n;j++){
         if(set.contains(arr[j])){
            break;
         }

         set.add(arr[j]);
         maxLen = Math.max(maxLen, j-i+1);
    }
   }

     return maxLen;




        // vvip concept 
        // Done using sliding window (sliding window is often combined with hashmap to keep track of element in the window )
        // HashMap<Character,Integer> map = new HashMap<>();
        // int l=0;  // left
        // int maxLength=0;
        // for(int r=0;r<s.length();r++){
        //     char c = s.charAt(r);// key 
        //     map.put(c,map.getOrDefault(c,0)+1);

        //     while(map.get(c)>1){
        //         char leftchar = s.charAt(l);
        //         map.put(leftchar,map.get(leftchar)-1);
        //         l++;
        //     }

        //     maxLength = Math.max(maxLength,r-l+1); 

        // }
        // return maxLength;
    }
}
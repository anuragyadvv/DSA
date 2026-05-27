class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
       
        Map<Character,List<Integer>> map = new HashMap<>();

        int lastLowerIdx[] = new int[26];
        Arrays.fill(lastLowerIdx,-1);

        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                   List<Integer> indices = map.getOrDefault(ch, new ArrayList<>());
                   indices.add(i);
                    map.put(ch,indices);
            }else{
                lastLowerIdx[ch-'a'] = i;
            }
           
        }

         int count =0;
         Set<Character> counted  = new HashSet<>();


        for(int i=0;i<n;i++){
            char ch = word.charAt(i);

            if(Character.isUpperCase(ch)){
                continue;
            }

            if(!counted.contains(ch) && map.containsKey(Character.toUpperCase(ch))){
              int lastLower = lastLowerIdx[ch-'a'];
              int firstUpper = map.get(Character.toUpperCase(ch)).get(0);

              if(lastLower<firstUpper){
                count++;
                counted.add(ch);
              }

                

            }
        }

        return count;
        
    }
}
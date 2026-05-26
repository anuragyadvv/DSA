class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int count =0;
        Set<Character> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(word.charAt(i));
        }

        for(int j=0; j<n ;j++){
            char ch = word.charAt(j);
            if(Character.isUpperCase(ch)){
                continue;
            }

            if(set.contains(Character.toUpperCase(ch))){
                count++;
                set.remove(Character.toUpperCase(ch));
            }
        }

        return count;
        
    }
}
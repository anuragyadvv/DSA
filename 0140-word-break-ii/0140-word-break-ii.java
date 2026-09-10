class Solution {
    List<String> res;
    HashSet<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet<>(wordDict);
        res = new ArrayList<>();

        String currSentence ="";

        solve(0,currSentence,s);

        return res;

        
    }

    public void solve(int i , String currSentence , String s){

        if(i>= s.length()){
            res.add(currSentence.trim());
            return;
        }

        for(int j=i ; j<s.length(); j++){
            String tempWord = s.substring(i,j+1);

            if(dict.contains(tempWord)){

                String tempSentence = currSentence ;

                if(!currSentence.isEmpty()){
                    currSentence += " ";
                }

                currSentence += tempWord; // take 

                solve(j+1,currSentence,s); // explore 

                currSentence = tempSentence; // untake  remove tempWord 
            }
        }
    }
}
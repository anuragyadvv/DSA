class Solution {
    public boolean isMatch(String s, String p) {

        if(p.length()==0){
            return s.length()==0;
        }
        
        boolean firstCharMatched = false;

        if(s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
            firstCharMatched = true;
        }

        if(p.length()>= 2 && p.charAt(1)=='*'){
            boolean notTake = isMatch(s,p.substring(2));
            boolean take = (firstCharMatched && isMatch(s.substring(1),p));

            return notTake || take ;
        }
        else{
            return firstCharMatched && isMatch(s.substring(1), p.substring(1));
        }
    }
}
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s,0,curr, result,n);
        return result;
        
    }

    public void backtrack(String s, int idx, List<String>curr, List<List<String>>result,int n){
        if(idx==n){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx;i<n;i++){
            if(isPalindrome(s,idx,i)){
               curr.add(s.substring(idx,i+1));
               backtrack(s,i+1,curr,result,n);
               curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int l , int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
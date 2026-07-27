class Solution {  // if only asked  no of valid parenthesis in that case we can directly uses catlan number 
    public List<String> generateParenthesis(int n) {

        List<String>res= new ArrayList<>();

        dfs(0,0,"",n,res);

        return res;
        
    }

    public void dfs(int openp,int closep,String s,int n,List<String>res){

        if(s.length()==2*n){
            res.add(s);
            return ;
        }

        if(openp<n){
            s=s+"(";
            dfs(openp+1,closep,s,n,res);
            s= s.substring(0,s.length()-1);
        }

        if(closep<openp){
            s=s+")";
              dfs(openp,closep+1,s,n,res);
                s= s.substring(0,s.length()-1);

        }
    }
}
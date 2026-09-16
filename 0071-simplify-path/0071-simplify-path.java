class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();


        // Tokenize using "/" as the delimiter
        String tokens[] = path.split("/");

        for(String token : tokens){

            if(token.isEmpty() || token.equals(".")){
                continue;
            }

            if(!token.equals("..")){
                s.push(token);
            }

            else if(!s.isEmpty()){
                s.pop();
            }

        }

        if(s.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        // Iterating over a Java Stack visits elements from bottom to top (FIFO order)
        for(String dir: s){
            sb.append("/").append(dir);
        }

        return sb.toString();
        
    }
}
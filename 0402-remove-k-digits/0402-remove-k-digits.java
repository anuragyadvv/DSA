class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if(k==n){
            return "0";
        }

        Stack<Integer> s = new Stack<>();

        s.push(num.charAt(0)-'0');

        for(int i=1;i<n;i++){
            char ch = num.charAt(i);
            int number = ch-'0';
            
            while(!s.isEmpty() && k>0 && s.peek()>number){
                s.pop();
                k--;
            }
            s.push(number);
        }
  
       //  If k is still > 0, remove the remaining digits from the top
        while(!s.isEmpty() && k>0){
            s.pop();
            k--;
        }

        // traverse on stack from bottom to top and append it to stringBuilder 
        StringBuilder sb = new StringBuilder();

        for (int snum : s){
          char ch = (char)(snum+'0');

          if(sb.isEmpty() && ch =='0'){
            continue;
          }
          sb.append(ch);
        }

        return sb.length()==0? "0": sb.toString();
        
    }
}
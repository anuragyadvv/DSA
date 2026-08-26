class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        
        String shortestStr = "";
        int minLength = Integer.MAX_VALUE;


        for(int i=0;i<n;i++){
            int count =k;
            StringBuilder temp = new StringBuilder();
            for(int j=i;j<n;j++){
                if(arr[j]=='1') count--;
                temp.append(arr[j]);

                if(count==0){
                   if(temp.length()<minLength  || (temp.length()==minLength && (temp.toString().compareTo(shortestStr)<0))){
                    minLength = temp.length();
                    shortestStr = temp.toString();
                   }
                }
            }
        }

        return shortestStr;
        
    }
}
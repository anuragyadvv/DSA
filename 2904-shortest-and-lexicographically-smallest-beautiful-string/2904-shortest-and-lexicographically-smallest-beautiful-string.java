class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
   // Brute force 
        // char arr[] = s.toCharArray();
        // int n = arr.length;
        
        // String shortestStr = "";
        // int minLength = Integer.MAX_VALUE;


        // for(int i=0;i<n;i++){
        //     int count =k;
        //     StringBuilder temp = new StringBuilder();
        //     for(int j=i;j<n;j++){
        //         if(arr[j]=='1') count--;
        //         temp.append(arr[j]);

        //         if(count==0){
        //            if(temp.length()<minLength  || (temp.length()==minLength && (temp.toString().compareTo(shortestStr)<0))){
        //             minLength = temp.length();
        //             shortestStr = temp.toString();
        //            }
        //         }
        //     }
        // }

        // return shortestStr;


        // Sliding window 
        char arr[] = s.toCharArray();
        int n = arr.length;

        int i=0;
        int j=0;
        int ones =0;
        String result ="";

        while(j<n){
            if(arr[j]=='1') ones++;

            while(ones>k || (ones==k && arr[i]=='0')){
                if(arr[i]=='1'){
                    ones--;
                }
                i++;
            }

            if(ones==k){
                int len = j-i+1;
                String temp = s.substring(i,i+len);

                if(result.length()==0 || result.length()>len  || (result.length()==len && (temp.compareTo(result)<0 )) ){
                    result = temp;
                }
            }
            j++;
        }

        return result;
        
    }
}
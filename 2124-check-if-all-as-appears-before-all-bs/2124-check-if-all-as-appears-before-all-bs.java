class Solution {
    public boolean checkString(String s) {

        boolean aafterb = false;
        boolean bappear = false;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                bappear = true;
            }

        

            if(bappear){
                if(s.charAt(i)=='a'){
                    aafterb = true;
                    return false;
                }
            }
        }
       
       if(aafterb){
        return false;
       }

       return true;
        
    }
}
class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        allhappyString(n,k, sb, happyList, true, true, true);
        // Collections.sort(happyList);  // because they will be in sorted order only 

        if(k> happyList.size()){
            return "";
        }
       
       return happyList.get(k-1);
    }

//  now optimization
    public void allhappyString(int n,int k,  StringBuilder sb, List<String> happyList, boolean aturn, boolean bturn,
            boolean cturn) {

                if(happyList.size()==k){
                    return;
                }

        if (sb.length() == n) {
            happyList.add(sb.toString());
            return;
        }

        //   choice 1- add a
        if (aturn) {
            sb.append('a');
           
            allhappyString(n,k, sb,happyList, false, true, true);
            sb.deleteCharAt(sb.length() - 1);
            aturn = true;
        }

        //    choice 2- add b
        if (bturn) {
            sb.append('b');
         
            allhappyString(n,k, sb, happyList, true,false, true);
            sb.deleteCharAt(sb.length() - 1);
            bturn = true;
        }

        //    choice 3- add c 
        if (cturn) {
            sb.append('c');
            
            allhappyString(n,k, sb, happyList, true, true, false);
            sb.deleteCharAt(sb.length() - 1);
            cturn = true;
        }

    }
}
class Solution {
    public int minimumDeletions(String s) {
        // question wants that all the a's should be at the left and all the b's should be at the right we need to do this with minimum no of deletions 

    // Appraoch - 1 (using stack)
    // int n = s.length();
    // int count =0;
    // Stack<Character> st = new Stack<>();

    // for(int i=0;i<n;i++){
    //     if( !st.isEmpty() && s.charAt(i)=='a' && st.peek()=='b'){  //means b ke baad a aa gya hai 
    //     st.pop();
    //     count++; 
    //     }
    //     else{
    //         st.push(s.charAt(i));
    //     }
    // }

    // return count;

    // Approach - 2 (using two arrays )
    int n = s.length();
    int left_b_count[] = new int[n];
    int right_a_count[] = new int[n];
    

    left_b_count[0]=0;
    for(int i=1;i<n;i++){
        if(s.charAt(i-1)=='b'){
            left_b_count[i] = left_b_count[i-1]+1;
        }else{
            left_b_count[i] = left_b_count[i-1];
        }
    }

    right_a_count[n-1] = 0;
    for(int i=n-2;i>=0;i--){
        if(s.charAt(i+1)=='a'){
            right_a_count[i] = right_a_count[i+1] +1;
        }else{
            right_a_count[i] = right_a_count[i+1];
        }
    }

    int minDeletion = Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      minDeletion = Math.min(minDeletion ,(left_b_count[i]+ right_a_count[i]));
    }


    return minDeletion;





    // Approach - 3
        // int res =0;
        // int count =0;

        // for(char c: s.toCharArray()){
        //     if(c=='b'){
        //         count++;
        //     }else if(count!=0){
        //         // a found after b
        //         count--;
        //         res++;
        //     }
        // }
        // return res;
        
    }
}
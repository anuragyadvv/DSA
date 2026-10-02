class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
       

        for(int i=0;i<n;i++){

            st.push(nums[i]);

           while(st.size()>=2){
            int num2 = st.pop();
            int num1 = st.pop();

            if(isNonCoPrime(num1, num2)){

                int num = findLCM(num1,num2);
                st.push(num);

            }else{
                st.push(num1);
                st.push(num2);
                break;
            }
           }

           
        }

        for(int num : st){
            list.add(num);
        }
        return list;
        
    }

    public boolean isNonCoPrime(int a, int b){ // means GCD(a,b)>1 means here we are writing the code of GCD 

        while(b!=0){
            int temp = a%b;
            a= b;
            b= temp;
        }

        if(a>1){
            return true;
        }

        return false;
    }

    public int findLCM(int a, int b){ // ppt = LCM(n1,n2)*GCD(n1,n2) = n1*n2  => lcm = (n1*n2)/gcd;

     int n1 = a;
     int n2 = b;

    // finding gcd 
     while(b!=0){
        int temp = a%b;
        a= b;
        b= temp;
     }

     int gcd = a; 

     int lcm =(int) (((long) n1*n2)/gcd);

     return lcm;
        
    }
}
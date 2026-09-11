class Solution {
    public int totalNumbers(int[] digits) {
        // Brute force 
        // Set<Integer> set = new HashSet<>();
        // int n = digits.length;
        // int num =0;

        // for(int i=0;i<n; i++){
        
        //     for(int j=0;j<n;j++){
        //         for(int k=0;k<n;k++){

        //             if(i==j || j==k ||i==k) continue;


        //             num = num*10 + digits[i];
        //             num = num*10 + digits[j];
        //             num = num*10 + digits[k];

                    

        //             if(num%2 ==0  && num>= 100){
        //                 set.add(num);
        //             }

        //             num = num/1000;

        //         }

        //     }
        // }

        // return set.size();


        // m-2 

        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[digits.length];

        solve(digits, visited, set, 0, 0);

        return set.size();
        
    }

    private void solve(int[] digits, boolean[] visited, Set<Integer> set, int count, int num) {
        // Base case: formed a 3-digit number
        if (count == 3) {
            if (num % 2 == 0) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;

            // Prevent leading zero as the first digit
            if (count == 0 && digits[i] == 0) continue;

            visited[i] = true;
            solve(digits, visited, set, count + 1, num * 10 + digits[i]);
            visited[i] = false; // backtrack
        }
    }

}
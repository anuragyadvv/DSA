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


        // m2- more optimized 
        int n = digits.length;

        Set<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(digits[i], map.getOrDefault(digits[i],0)+1);
        }

        for(int i=1;i<=9;i++){
            if (map.getOrDefault(i, 0) == 0) continue;
            map.put(i, map.get(i)-1);
            
            for(int j=0; j<=9 ;j++){
                if (map.getOrDefault(j, 0) == 0) continue;
                map.put(j, map.get(j)-1);

                for(int k=0;k<=8; k=k+2){
                    if (map.getOrDefault(k, 0) == 0) continue;
                    map.put(k, map.get(k)-1);

                    int num = (i*100)+(j*10)+(k);
                    set.add(num);

                    map.put(k, map.getOrDefault(k,0)+1);
                }
              map.put(j, map.getOrDefault(j,0)+1);  
            }

            map.put(i, map.getOrDefault(i,0)+1);
        }

        return set.size();





        // m-3(using bactracking )

        // Set<Integer> set = new HashSet<>();
        // boolean[] visited = new boolean[digits.length];

        // solve(digits, visited, set, 0, 0);

        // return set.size();
        
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
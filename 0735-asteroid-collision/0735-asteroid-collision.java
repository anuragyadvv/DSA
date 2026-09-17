class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
          
        //   condition for collision 
            while (!s.isEmpty() && s.peek() >0  && asteroids[i] < 0) {
              int sum = asteroids[i]+s.peek();

              if(sum<0){
                s.pop();
              }
              else if(sum>0){
                asteroids[i] =0; // to break the while condition for collision 
                
              }
              else{ // sum =0
              s.pop();
              asteroids[i] = 0;

              }
            }

            if (asteroids[i] != 0) {
                s.push(asteroids[i]);
            }

        }

        if (s.isEmpty()) {
            return new int[0];
        }

        int result[] = new int[s.size()];
        int j = 0;

        // traversing on stack from bottom to top 
        for (int val : s) {
            result[j] = val;
            j++;
        }

        return result;

    }
}
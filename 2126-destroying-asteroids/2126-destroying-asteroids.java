class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long currentMass = mass;
        for(int i=0;i<n;i++){
            if(currentMass>=asteroids[i]){
                currentMass+= asteroids[i];
            }else{
                return false;
            }
        }

        return true;
        
    }
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int n = arr1.length;
        int m = arr2.length;

        // Brute force - O(n2)

        int count = 0;
       

        for(int i=0;i<n;i++){
              boolean conditionSatisfied = true;
            for(int j =0 ;j<m;j++){
               
                if(Math.abs(arr1[i]-arr2[j])<= d){
                    conditionSatisfied = false;
                    break;
                }
            }

            if(conditionSatisfied){
                count++;
            }

        }

        return count;
        
    }
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        // int n = arr1.length;
        // int m = arr2.length;

        // // Brute force - O(n2)

        // int count = 0;
       

        // for(int i=0;i<n;i++){
        //       boolean conditionSatisfied = true;
        //     for(int j =0 ;j<m;j++){
               
        //         if(Math.abs(arr1[i]-arr2[j])<= d){
        //             conditionSatisfied = false;
        //             break;
        //         }
        //     }

        //     if(conditionSatisfied){
        //         count++;
        //     }

        // }

        // return count;


        // Approach - 2 

        int n = arr1.length;
        int m = arr2.length;

        int count = 0;

        Arrays.sort(arr2);

      for (int i=0;i<n;i++){
        int j = lowerBound(arr2, arr1[i]);

        if(j==0){//all elements are greater or equal to arr1[i]
          if(arr2[0]-arr1[i]>d) count++;
        }
        else if (j>=m){ //all elements are smaller than arr1[i]
           if(arr1[i]-arr2[m-1]>d) count++;

        }
        else{
            if(arr2[j]-arr1[i]>d && arr1[i]- arr2[j-1] > d) count++;
        }
      }

      return count;
        
    }


    private int lowerBound(int arr[], int target){
        int low = 0;
        int high = arr.length;

        while(low<high){
            int mid = low +(high-low)/2;

            if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }
}
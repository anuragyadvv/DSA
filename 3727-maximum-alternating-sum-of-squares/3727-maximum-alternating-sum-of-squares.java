class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Math.abs(nums[i]);
        }

        Arrays.sort(arr);

        int i=0;
        int j=n-1;
        long result =0;

        while(i<j){
          result += ((arr[j]*arr[j])-(arr[i]*arr[i]));
          j--;
          i++;
        }

        if(n%2 !=0){ // odd length so add square of the middle element at last 
        result += (arr[n/2]*arr[n/2]);

        }

        return result;
        
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        //Approach -1 (using recursion TLE ) 

        // int n = nums.length;

    //    int ans = solve(0,n-1,nums,x);

    //  return ans >= 1000000 ? -1 : ans;



    // Approach -2 (using hashMap )

    // total sum of all the elements of array = sum

    // Intution = [left| sum-x  |right]   let left + right = x
    // so:  left + sum-x + right = sum => we can say :  left + right = x

    //  So find  longest subarray sum whose sum = sum-x  and have length L and try to make L large then only we can get left and right small  and to find ans do n-L where n is length of array 
    //  we have done question like find subarray sum equal to k here k = sum -x (leetcode 560 and 523)

    int n = nums.length;
    int totalSum =0;
    // find total sum 
    for(int i=0;i<n;i++){
        totalSum += nums[i];
    }

     int targetSum = totalSum-x; 

     if(targetSum<0){
        return -1;
     }

     if(targetSum==0) return n;

    // hashMap will store sum and index  initially sum=0 and index =-1 (code for subarray sum equal k )
    int sum =0;
    int length = -1;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,-1);  // initially sum=0 and index =-1 

    for(int j=0;j<n;j++){
        sum += nums[j];

        if(map.containsKey(sum-targetSum)){
            length = Math.max(length, j-map.get(sum-targetSum));

        }
        if(!map.containsKey(sum)){
            map.put(sum, j);
        }
    }

    return length ==-1? -1 : n-length;

        
    }



    public int solve(int i, int j, int nums[], int x){

          if(x==0){
            return 0;
        }

        if(x<0 || i>j){
            return 1000000;
        }

      

        int removeLast = solve(i,j-1,nums,x-nums[j]);
        int removeFirst = solve(i+1,j,nums, x-nums[i]);

        int minRes =  Math.min(removeLast, removeFirst);

        return minRes >= 1000000? 1000000: minRes+1;


    }
}
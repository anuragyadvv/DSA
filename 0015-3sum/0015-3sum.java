class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
    //Approach -1     Brute force - o(n3)

//     int n = nums.length;
//    Set<ArrayList<Integer>> set = new HashSet<>();
//     for(int i=0;i<n-2;i++){
//         for(int j=i+1;j<n-1;j++){
//             for(int k=j+1;k<n;k++){

               
//                 if(nums[i]+nums[j]+nums[k]==0){
//                      ArrayList<Integer>list = new ArrayList<>();
//                     list.add(nums[i]);
//                     list.add(nums[j]);
//                     list.add(nums[k]);

//                     Collections.sort(list);

//                     set.add(list);
//                 }
//             }
//         }
//     }

//     return new ArrayList<>(set);



// Approach -2  optimized  (sort the array and use three pointers fix one pointer and other two pointer will move )
       
       if(nums==null || nums.length <3){
        return new ArrayList<>();
       }
       Set<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
           
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
            
                int total = nums[i] + nums[left] + nums[right];

                if(total == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    Collections.sort(list);
                    set.add(list);
                    left++;
                    right--;
                }

                 else if (total < 0) {
                    left++;
                } else {
                  right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
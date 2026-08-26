class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
    //    Brute force - o(n3)
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

//   optimized  (sort the array and use three pointers fix one pointer and other two pointer will move )

       Set<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                

                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                   ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    Collections.sort(list);
                    set.add(list);
                    j++;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
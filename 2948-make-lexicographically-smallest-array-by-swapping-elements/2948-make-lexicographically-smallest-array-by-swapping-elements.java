class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        // Brute force 
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {

        //     while (true) {

        //         int smallVal = nums[i];
        //         int idx = -1;
        //         for (int j = i + 1; j < n; j++) {
        //             if(Math.abs(nums[i]-nums[j])<=limit){
        //                 if(nums[j]<smallVal){
        //                     smallVal = nums[j];
        //                     idx =j;
        //                 }
        //             }
        //         }

        //         if(idx!=-1){
        //             int temp = nums[i];
        //             nums[i] = nums[idx];
        //             nums[idx] = temp; 
        //         }else{
        //             break;
        //         }

        //     }
        // }

        // return nums;


        // optimized 
        int n = nums.length;
        int vec[] = nums.clone();

        Arrays.sort(vec);


        int groupNum =0;
        Map<Integer,Integer> numToGroup  = new HashMap<>();
        Map<Integer,LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vec[0],groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(vec[0]);

        for(int i=1;i<n;i++){
           if(Math.abs(vec[i]-vec[i-1])>limit) {
            groupNum++;
           }

           numToGroup.put(vec[i],groupNum);
           groupToList.putIfAbsent(groupNum, new LinkedList<>());
           groupToList.get(groupNum).add(vec[i]);
        }


        int result[] = new int[n];
        for(int i=0;i<n;i++){
            int num = nums[i]; // traversing on input array 
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst(); //use and remove the smallest element 
        }

    return result;

    }
}
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        // Brute force 
        // int n = nums1.length;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap (stores element in descending order)
        // int k = k1+k2;

        // long result = 0;

        // for(int i=0;i<n;i++){
        //     pq.add(Math.abs(nums1[i]-nums2[i]));
        // }

        // while(k>0 && pq.peek()>0){
        //     int num = pq.remove();
        //     pq.add(num-1);
        //     k--;
        // }

        // while(!pq.isEmpty()){
        //     int num = pq.remove();
        //     result += (num*num);
        // }

        // return result;

        // optimal 

        int n = nums1.length;

        int countDiff[] = new int[100001];

        for(int i=0;i<n;i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            countDiff[diff]++;
        }

        int k = k1+k2;

        for(int currDiff = 100000; currDiff>0 && k>0 ;currDiff--){

            int countOps = Math.min(countDiff[currDiff], k);
            countDiff[currDiff] -= countOps;
            countDiff[currDiff-1] += countOps;
            k -= countOps;

        }

        long result =0;
        for(long d=1; d<=1e5 ; d++){
            result += (long)(countDiff[(int)d]* d*d);
        }

        return result;


        
    }
}
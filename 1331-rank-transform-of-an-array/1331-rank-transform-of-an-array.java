class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        int copy[] = Arrays.copyOf(arr, arr.length);

        Arrays.sort(copy);
        Map<Integer,Integer> map = new HashMap<>();
         
         int counter = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(copy[i])){
               map.put(copy[i], counter);
          counter++;
            }
          
        }

        for(int i=0;i<n;i++){
            res[i] = map.get(arr[i]);
        }

        return res;


        
    }
}
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
         // Sort logs by time (index 1)
        Arrays.sort(logs,(a,b)->a[1]-b[1]);

        int q = queries.length;
        int timeIndex[][] = new int[q][2]; // {time, original index}

        for(int i=0;i<q;i++){
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }
        
           // Sort timeIndex by time
        Arrays.sort(timeIndex,(a,b)-> a[0]-b[0]);

        Map<Integer,Integer> map = new HashMap<>();
        int result[] = new int[q];

        // sliding window(two pointers )
        int i=0;
        int j=0;

        for(int[] pair: timeIndex){
            int curTime = pair[0];
            int idx = pair[1];

            int start = curTime -x;
            int end = curTime;

            // Right expand: time <= end
            while(j<m && logs[j][1]<=end){
                int serverId = logs[j][0];
                map.put(serverId, map.getOrDefault(serverId,0)+1);
                j++;
            }

            // Left shrink: time < start
            while(i<m && logs[i][1]< start){
                int serverId = logs[i][0];

                map.put(serverId, map.get(serverId)-1);
                if(map.get(serverId)==0){
                    map.remove(serverId);
                }
                i++;
            }


            result[idx] = n - map.size();
        }

        return result;
        
    }
}
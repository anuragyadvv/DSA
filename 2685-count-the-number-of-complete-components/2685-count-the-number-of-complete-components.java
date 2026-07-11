class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int result =0;
        for(int edge[]:edges){
            adj.putIfAbsent(edge[0],  new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean visited[]= new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==true) continue;

            int info[] = new int[2];
            // info[0] store no of vertices  and info[1] = 2* no of edges
            dfs(i,adj,visited,info);

            if(info[0]*(info[0]-1)==info[1]){
                result++;
            }


        }

        return result;
        
    }

    public void  dfs(int i , Map<Integer,List<Integer>>adj, boolean visited[], int info[]){
        visited[i]= true;
        info[0]++;
        info[1]+= adj.getOrDefault(i, new ArrayList<>()).size();

        for(int neigh: adj.getOrDefault(i,new ArrayList<>())){
            if(!visited[neigh]){
                dfs(neigh,adj,visited,info);
            }
        }
    }
}
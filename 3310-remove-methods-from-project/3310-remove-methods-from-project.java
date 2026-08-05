class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // for making graph 
        List<Integer> edges[] = new ArrayList[n];

        for(int i=0;i<n;i++){
            edges[i] = new ArrayList<>();
        }

        int inDegree[] = new int [n];

        for(int inv[] : invocations){
            edges[inv[0]].add(inv[1]);
            inDegree[inv[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        boolean sus[] = new boolean[n];
        sus[k] = true;

        while(!q.isEmpty()){
            int u = q.remove();
            for(int v : edges[u]){
                inDegree[v]--;

                if(!sus[v]){
                    q.add(v);
                    sus[v] = true;
                }
            }
        }


        boolean canRemoveAll = true;
        List<Integer> rem = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(sus[i] && inDegree[i]>0){
                canRemoveAll = false;
                break;
            }
            else if(!sus[i]){
                rem.add(i);
            }
        }

        if(!canRemoveAll){
            List<Integer> allNodes = new ArrayList<>(n);
            for(int i=0; i<n ; i++){
                allNodes.add(i);
            }

            return allNodes;
        }

        return rem;
        
    }
}
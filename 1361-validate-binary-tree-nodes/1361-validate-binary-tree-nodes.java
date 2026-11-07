class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Map<Integer, List<Integer>> parentToChildren = new HashMap<>(); // to make adjacency list 
        Map<Integer,Integer> childToParent = new HashMap<>();

        for(int i=0;i<n;i++){
            int node = i;
            int leftC = leftChild[i];
            int rightC = rightChild[i];

            if(leftC != -1){
                parentToChildren.computeIfAbsent(node ,k-> new ArrayList<>()).add(leftC);

                if(childToParent.containsKey(leftC)){
                    return false;

                }
                else{
                    childToParent.put(leftC,node);
                }
            }


            if(rightC != -1){
                parentToChildren.computeIfAbsent(node,k->new ArrayList<>()).add(rightC);

                if(childToParent.containsKey(rightC)){
                    return false;
                }
                else{
                    childToParent.put(rightC, node);
                }
            }
        }

        int root = -1;

        for(int i=0; i<n;i++){
            if(!childToParent.containsKey(i)){
                if(root!= -1){
                    return false;
                }else{
                    root = i;
                }
            }
        }

        if(root==-1) return false; 


        // normal BFS/DFS for traversal 

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        boolean visited[] = new boolean[n]; 

        q.add(root);
        count =1;
        visited[root] = true;

        while(!q.isEmpty()){
            int node = q.remove();


            for(int child : parentToChildren.getOrDefault(node,Collections.emptyList())){
                if(!visited[child]){
                    visited[child] = true;
                    count++;
                    q.add(child);
                }
            }
        }


        return count==n;  // we should be able to visit all nodes during BFS/DFS


        
    }
}
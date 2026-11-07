/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();  // store every node parent 

        inorder(root,map);

        List<Integer> result = new ArrayList<>();

        BFS(target,k,result,map);

        return result;

        
    }

    public void inorder(TreeNode root, Map<TreeNode,TreeNode>map){

        if(root==null) return ;

        if(root.left !=null){
            map.put(root.left, root);
            inorder(root.left,map);
        }

        if(root.right !=null){
            map.put(root.right, root);

            inorder(root.right,map);
        } 
    }


    public void BFS(TreeNode target, int k , List<Integer> result, Map<TreeNode,TreeNode>map){
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        int currLevel =0 ;

        while(!q.isEmpty()){
           int n = q.size();

           if(currLevel == k) break;

           while(n-->0){
            TreeNode node = q.poll();

            // for  left child of node 
            if(node.left != null && !visited.contains(node.left.val)){
               q.offer(node.left);
               visited.add(node.left.val);
            }
           // for right child of node 
           if(node.right != null && !visited.contains(node.right.val)){
            q.offer(node.right);
            visited.add(node.right.val);
           }

        //    for parent of node 
          if(map.get(node) != null && !visited.contains(map.get(node).val)){
            q.offer(map.get(node));
            visited.add(map.get(node).val);
          }

           }

           currLevel++ ;

        }

        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null){
           return result;
        }
       
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean flag = false; // means in same order  flag = true means in reverse order
        while(!q.isEmpty()){
            int size = q.size();
            Stack<Integer> s = new Stack<>(); // for storing in reverse order
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                
                if(flag){
                    s.push(node.val);
                }else{
                    list.add(node.val);
                }

                if(node.left!= null){
                    q.add(node.left);
                }
                if(node.right !=null){
                    q.add(node.right);
                }
            }

            flag = !flag;

            while(!s.isEmpty()){
                list.add(s.pop());
            }

            result.add(list);
        }

        return result;
        
    }
}
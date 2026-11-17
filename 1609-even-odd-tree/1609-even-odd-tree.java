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

    // Approach 1 (using BFS (level order traversal))
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        int level = -1;

        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            level ++;

            int prev = (level %2 == 0)? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while(n-- >0){

                if(level%2 == 0){ // even indexed (this level should have odd integer values and and should be strictly increasing )

                TreeNode node = q.poll();

                
                    if(node.val % 2 == 0 || node.val <= prev){
                    return false;
                }
                

                prev = node.val;
                
                

                if(node.left !=null){
                    q.add(node.left);
                }

                 if(node.right !=null){  
                    q.add(node.right);
                }

                } else{ // odd indexed (this level should have even integer values and and should be strictly decreasing)

                TreeNode node = q.poll();
               
                    if(node.val % 2 != 0 || node.val >=prev){
                    return false;
                }
                

                prev = node.val;
                

                if(node.left !=null){
                    q.add(node.left);
                }

                 if(node.right !=null){  
                    q.add(node.right);
                }

                }
            }
        }

        return true;
        
    }
}
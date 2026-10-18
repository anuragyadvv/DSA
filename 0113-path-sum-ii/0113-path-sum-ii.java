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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(root, targetSum, 0, res, list);

        return res;
        
    }

    public void solve(TreeNode root, int targetSum, int currSum,  List<List<Integer>> res, List<Integer> list ){

        if(root==null){
            return;
        }

        list.add(root.val);
        currSum += root.val;
        

          if(root.left ==null && root.right==null){ // leaf node 
            if(currSum==targetSum){
                res.add(new ArrayList<>(list));
                
            } 
        }
        
        solve(root.left, targetSum, currSum, res, list );
       
        solve(root.right, targetSum, currSum, res,list);

        list.remove(list.size()-1);
    }
}
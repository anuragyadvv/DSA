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

    int count ;
    public int pseudoPalindromicPaths (TreeNode root) {

        count =0;
        int[] freq= new int[10];

        solve(root, freq);

        return count;

        
    }

    public void solve(TreeNode root, int freq[]){

        if(root==null){
            return ;
        }

        freq[root.val]++;

        if(root.left==null && root.right == null){
            int oddFreq = 0;
            for(int num : freq){
                if(num%2 !=0){
                    oddFreq++;
                }
            }

            if(oddFreq<=1){
                count++;
            }
        }

        solve(root.left, freq);
        solve(root.right, freq);

        freq[root.val]--;
    }
}
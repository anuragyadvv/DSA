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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Approach - find path for both given nodes and stores in a list  then compare both the list and the last common node will be my LCA 
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        getPath(root, p , path1); // store path to reach till p
        getPath(root,q , path2);  // store path to reach till q

        //  now we have path to reach p and q now find  last common node to find LCA 
        TreeNode lca = null;
        int i=0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i) == path2.get(i)){
               lca = path1.get(i);
            }
        }

     return lca;   
    }

    public boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path){

        if(root==null){
            return false;
        }

        path.add(root);
        if(root == n){
            return true;
        }

        boolean foundLeft = getPath(root.left,n,path);
        boolean foundRight = getPath(root.right,n,path);

        if(foundLeft || foundRight){
            return true;
        }
        // Backtrack 
        path.remove(path.size()-1);

        return false;



    }
}
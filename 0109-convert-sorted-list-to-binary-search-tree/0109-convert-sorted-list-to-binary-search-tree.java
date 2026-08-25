/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    // brute force 
   
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null ){
            return null;
        }
       ArrayList<Integer> list = new ArrayList<>();
       ListNode temp = head;
       while(temp!= null){
        list.add(temp.val);
        temp = temp.next;
       } 

       int n = list.size();

       TreeNode root = buildBST(list,0,n-1);

       return root;
    }

    public TreeNode buildBST(ArrayList<Integer> list , int left, int right){
          if(left> right){
            return null;
          }

          int mid = left +(right-left)/2;

          TreeNode root = new TreeNode(list.get(mid));

        //   recursively call for left and right subtree

        root.left = buildBST(list,left,mid-1);
        root.right = buildBST(list,mid+1,right);

        return root;
    }
}
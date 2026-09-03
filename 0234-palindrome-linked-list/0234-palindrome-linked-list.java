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
class Solution {
    public boolean isPalindrome(ListNode head) {

    // approach -1 Using ArrayList
    ArrayList<Integer> list = new ArrayList<>(); 
     ListNode temp = head;

     while(temp!= null){
       list.add(temp.val);
       temp = temp.next;
     }

     int n = list.size();

     for(int i=0;i<n/2 ; i++ ){
        if(list.get(i) != list.get(n-i-1)){
            return false;
        }
     }

     return true;




        // Approach -2 
        // ListNode slow=head;
        // ListNode fast=head;
        // while(fast!=null && fast.next!=null){
        //     slow=slow.next;
        //     fast=fast.next.next;

        // }
        // ListNode midnode=slow;
        
        // if(head==null || head.next==null){
        //       return true;
        // }
        
        // ListNode curr= midnode;
        // ListNode prev=null;
        // ListNode next;
        
        // while(curr!=null){
        //     next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;

        // }
        // ListNode right= prev;
        // ListNode left=head;
        
        // while(right!=null){
        //     if(left.val!=right.val){
        //         return false;

        //     }
        //     left=left.next;
        //     right=right.next;

        // }
        // return true;
        
    }
}
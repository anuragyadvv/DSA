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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null){
            return null;
        }
        int size =0;
        ListNode temp = head; 
        while(temp!=null){
            size++;
            temp= temp.next;
        }

        if(n==size){ // remove head node 
          head = head.next;
          return head;
        }

        temp =head;
        int i =0;
        ListNode prev= null;


        while(i<size-n){
            prev = temp;
            temp = temp.next;
            i++;
        }
         if(prev!=null){
        prev.next = temp.next;
         }
        

        return head;
        
    }
}
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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode (-1);

        ListNode smallP = smaller;
        ListNode largeP = larger;

        while(head!=null){
            if(head.val<x){
                smallP.next = head;
                smallP = smallP.next;
            }
            else{
                largeP.next = head;
                largeP = largeP.next; 
            }

            head = head.next;
            
        }

        largeP.next = null;
        smallP.next = larger.next;


        return smaller.next;


        
    }
}
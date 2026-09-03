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
    public ListNode doubleIt(ListNode head) {

        // Approach -1 (By reversing the linkedList)
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev will point to head 
         head = prev;

         curr = head;
         prev = null;
        int carry =0;


        while(curr != null){
            int newVal = curr.val*2  + carry;
            curr.val = newVal %10;
             if(newVal>= 10){
                carry = 1;
             }else{
                carry =0;
             }

             prev = curr;
             curr = curr.next;

        }

        if(carry >0){
            prev.next = new ListNode(carry);
        }


        // now again reverse the linkedList 

        curr = head;
        prev = null;
        ListNode next1;

        while(curr != null){
            next1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next1;
        }


        return prev;



        
    }


}
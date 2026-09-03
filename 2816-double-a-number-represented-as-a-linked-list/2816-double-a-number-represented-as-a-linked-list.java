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


        // ListNode curr = head;
        // ListNode next;
        // ListNode prev = null;

        // while(curr != null){
        //     next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }

        // // prev will point to head 
        //  head = prev;

        //  curr = head;
        //  prev = null;
        // int carry =0;


        // while(curr != null){
        //     int newVal = curr.val*2  + carry;
        //     curr.val = newVal %10;
        //      if(newVal>= 10){
        //         carry = 1;
        //      }else{
        //         carry =0;
        //      }

        //      prev = curr;
        //      curr = curr.next;

        // }

        // if(carry >0){
        //     prev.next = new ListNode(carry);
        // }


        // // now again reverse the linkedList 

        // curr = head;
        // prev = null;
        // ListNode next1;

        // while(curr != null){
        //     next1 = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr= next1;
        // }


        // return prev;



        // Approach - 2(using recursion)

        int lastCarry = doubleUtil(head);

        if(lastCarry >0){
            ListNode newNode = new ListNode(lastCarry);
            newNode.next = head;
            head = newNode;
        }

        return head;

        
    }
 
     public int doubleUtil(ListNode head){
        
        if(head==null) return 0;

        int carry = doubleUtil(head.next);
        int newVal = head.val *2 + carry;

        head.val = newVal %10;


        return newVal/10; // return carry
     }


}
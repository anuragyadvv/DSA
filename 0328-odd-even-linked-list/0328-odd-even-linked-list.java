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
    public ListNode oddEvenList(ListNode head) {

        // if(head==null || head.next == null){
        //     return head;
        // }
        // ListNode even = new ListNode(-1);
        // ListNode tempEven = even;
        // ListNode odd = new ListNode(-1) ;
        //  ListNode tempOdd = odd;

        // int i=1;
        // ListNode temp = head;
       
        // while(temp!=null){
        //     if(i%2!=0){
        //         tempOdd.next = temp;
        //         tempOdd = temp;
                
        //         temp = temp.next;
        //         i++;
        //     }else{
        //         tempEven.next = temp;
        //         tempEven = temp;
                
        //         temp = temp.next;
        //         i++;
        //     }
        // }
        // tempOdd.next = null;
        // tempEven.next = null;
        
        // ListNode evenHead = even.next;
        // ListNode oddHead = odd.next;
        //  ListNode temp2 = oddHead;
        //  ListNode prev = null;
        //  while(temp2!=null){
        //     prev = temp2;
        //     temp2= temp2.next;
        //  }

        //  prev.next = evenHead;

        //  return oddHead;

        // M2 - using two pointer

        if(head==null || head.next==null){
            return head;
        } 
        ListNode odd = head;
        ListNode even = head.next;
         ListNode evenStart = head.next;

         while(even !=null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next; 
         }

         odd.next = evenStart;

         return head;
        
    }
}
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
    public ListNode[] splitListToParts(ListNode head, int k) {

        // 1 find the length of linkedlist 
        ListNode curr = head;
        int L = 0;
        while (curr != null) {
            L++;
            curr = curr.next;

        }

        int eachBucketNodes = L / k;
        int extraNodes = L % k;

        ListNode result[] = new ListNode[k];

        curr = head;
        ListNode prev = null;

        for(int i=0;i<k;i++){ // to fill all k buckets 
          
          result[i] = curr;

          for(int count =1 ; count<=eachBucketNodes+(extraNodes > 0? 1:0); count++){
            prev = curr;
            curr = curr.next;
          }
           
           if(prev!=null){
                 prev.next = null;
           }
         
          extraNodes--;

        }

        return result;

    }
}
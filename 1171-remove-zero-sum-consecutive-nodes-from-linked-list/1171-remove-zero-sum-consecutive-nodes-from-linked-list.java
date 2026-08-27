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
    public ListNode removeZeroSumSublists(ListNode head) {

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head.val==0? null : head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        boolean zeroSum = false;

      for(int i=0;i<list.size();i++){
        int currSum =0;
        for(int j=i;j<list.size();j++){
            currSum += list.get(j);

            if(currSum==0){
               zeroSum = true;
               for(int k=j; k>=i;k--){
                list.remove(k);
                
               }
               i=-1; // because again i should start from 0th index  to check other currSum =0
               break;
            }
        }

       
      }

      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;

      for(Integer val : list){
        curr.next = new ListNode(val);
        curr = curr.next;
      }

       return dummy.next;
    }
}
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        //approach -1 

        int i=0;
        ListNode prev1= list1;
          
        while(i<a-1){
            prev1 = prev1.next;
            i++;
        }
            
        ListNode prev2 = list1;
        int j=0;
        while(j<b){
          prev2 = prev2.next;
          j++;
        }

        ListNode temp = list2;

        while(temp.next!=null){
            temp = temp.next;
        }

         prev1.next = list2;

         temp.next = prev2.next;


        return list1;
          

        
    }
}
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

    // Approach
    // 1. check if k node exist;
    // 2.recursively reverse rest of the LL
    // 3. Reverse the current group 
    public ListNode reverseKGroup(ListNode head, int k) {

        // 1. check if k node exist;
        ListNode temp = head;
        int count =0;
        while(count<k){

            if(temp==null){
                return head;
            }
            temp = temp.next;
            count++;

        }

        // 2. Recursively reverse rest of the linkedList
        ListNode prevNode = reverseKGroup(temp,k); // it will reverse all the node after first k nodes have faith in recursion 

        // 3. Reverse the current group
        temp = head;
        count =0;
        while(count<k){
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            count++;
        }

        return prevNode;
        
    }
}
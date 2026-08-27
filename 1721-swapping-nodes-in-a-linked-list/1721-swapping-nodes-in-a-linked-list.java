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
    public ListNode swapNodes(ListNode head, int k) {
        
        // Brute force approach - first I will store values of all the nodes in a list then I will perform swapping then again from the modified list I will create a linkedlist and return its head 

        List<Integer>list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp= temp.next;
        }

        int n = list.size();

        int t = list.get(k-1);
        list.set(k-1,list.get(n-k));
        list.set(n-k,t);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(Integer val : list){
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;

    }
}
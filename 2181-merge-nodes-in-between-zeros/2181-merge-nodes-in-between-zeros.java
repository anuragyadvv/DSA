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
    public ListNode mergeNodes(ListNode head) {

        // Approach -1 
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(temp!=null){
           list.add(temp.val);
           temp = temp.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size();

        int sum =0;

        for(int i=1;i<n;i++){
           sum += list.get(i);

           if(list.get(i)==0){
            res.add(sum);
            sum =0;
           }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(int val : res){
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
        
    }
}
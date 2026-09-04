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

        // Approach -1 (using ArrayList )
        // ListNode temp = head;
        // ArrayList<Integer> list = new ArrayList<>();
        // while(temp!=null){
        //    list.add(temp.val);
        //    temp = temp.next;
        // }

        // ArrayList<Integer> res = new ArrayList<>();
        // int n = list.size();

        // int sum =0;

        // for(int i=1;i<n;i++){
        //    sum += list.get(i);

        //    if(list.get(i)==0){
        //     res.add(sum);
        //     sum =0;
        //    }
        // }

        // ListNode dummy = new ListNode(-1);
        // ListNode curr = dummy;

        // for(int val : res){
        //     curr.next = new ListNode(val);
        //     curr = curr.next;
        // }

        // return dummy.next;


        // Approach -2 (tc -O(n) and sc- O(1))

        ListNode p1 = head.next;
        ListNode p2 = p1;

        while(p2 != null){
            int sum =0 ;

            while( p2 != null && p2.val != 0){
                sum += p2.val;
                p2 = p2.next;
            }

            p1.val = sum;
            p2 = p2.next;
            p1.next = p2;
            p1 = p1.next;
        }

        return head.next;
        
    }
}
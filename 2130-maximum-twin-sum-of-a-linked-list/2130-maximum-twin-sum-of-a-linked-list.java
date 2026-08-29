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
    public int pairSum(ListNode head) {

        // Brute force - take a list and add all values node then iterate on the list and perform the operation giveb in question and return the max twin value 
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int maxTwinSum = Integer.MIN_VALUE;


        for(int i=0;i<n/2;i++){
         maxTwinSum = Math.max(maxTwinSum, list.get(i)+list.get(n-1-i));
        }

        return maxTwinSum;






        // optimized approach 
        // Stack<Integer> half = new Stack<>();
        // ListNode slow = head;
        // ListNode fast = head;

        // while (fast != null && fast.next != null) {
        //     half.push(slow.val);
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // int res = 0;
        // while (slow != null) {
        //     res = Math.max(res, half.pop() + slow.val);
        //     slow = slow.next;
        // }

        // return res;
    }
}
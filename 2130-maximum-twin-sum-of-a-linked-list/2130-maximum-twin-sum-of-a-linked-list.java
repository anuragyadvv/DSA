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

        // Approach 1- take a list and add all values node then iterate on the list and perform the operation giveb in question and return the max twin value 
        // List<Integer> list = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // int n = list.size();
        // int maxTwinSum = Integer.MIN_VALUE;


        // for(int i=0;i<n/2;i++){
        //  maxTwinSum = Math.max(maxTwinSum, list.get(i)+list.get(n-1-i));
        // }

        // return maxTwinSum;






        //  approach 2- put all the nodes value in a stack then find stack size and do its half now iterate from first node and add the top of stack and this iteration will go till half size of stack  
        Stack<Integer> s = new Stack<>();
           
           ListNode temp = head;
        while(temp !=null){
            s.push(temp.val);
            temp= temp.next;
        }

        int halfSize = s.size()/2;
        int res = 0; 
        int i=0;
        ListNode curr = head;
         while(i<halfSize){
            res = Math.max(res, (s.pop()+curr.val));
            curr = curr.next;
            i++;
         } 

      
        return res;
    }
}
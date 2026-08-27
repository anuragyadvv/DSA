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

        // List<Integer>list = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp= temp.next;
        // }

        // int n = list.size();

        // int t = list.get(k-1);
        // list.set(k-1,list.get(n-k));
        // list.set(n-k,t);

        // ListNode dummy = new ListNode(-1);
        // ListNode curr = dummy;

        // for(Integer val : list){
        //     curr.next = new ListNode(val);
        //     curr = curr.next;
        // }

        // return dummy.next;


        // optimized way 

        // int length =0;
        // ListNode temp = head;
        // while(temp!=null){
        //     length++;
        //     temp=temp.next;
        // }

        // int k1 = k;
        // int i=0;
        // ListNode node1 = head;
        // while(i<k1-1){
        //    node1 = node1.next;
        //    i++;
        // }

        // int j=0;
        // int k2 = length - k;
        // ListNode node2 = head;
        // while(j<k2){
        //    node2 = node2.next;
        //    j++;
        // }

        // int x = node1.val;
        // node1.val = node2.val;
        // node2.val = x;

        // return head;


        // more optimized 

        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = head;

        while(temp!=null){

            if(p2!=null){
                p2= p2.next;
            }
            k--;

            if(k==0){
                p1 = temp;
                p2 = head;
            }

            temp = temp.next;
        }

        // swap values 
        int x = p1.val;
        p1.val = p2.val;
        p2.val = x;
     

     return head;

    }
}
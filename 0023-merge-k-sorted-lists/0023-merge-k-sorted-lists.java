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

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val<= l2.val){
            l1.next = mergeTwoSortedList(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoSortedList(l1,l2.next);
            return l2;
        }
    }


    public ListNode partitionAndMerge(int start, int end , ListNode lists[]){

        if(start==end){
            return lists[start];
        }

        if(start>end){
            return null;
        }

        int mid = start +(end-start)/2;

        ListNode l1 = partitionAndMerge(start,mid,lists);
        ListNode l2 = partitionAndMerge(mid+1,end,lists);

        return mergeTwoSortedList(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // m1- brute force 
        // ArrayList<Integer> list = new ArrayList<>();

        // for(ListNode head : lists){
        //     ListNode curr = head;
        //     while(curr!=null){
        //         list.add(curr.val);
        //         curr = curr.next;
        //     }
            
        // }
        // if(list.isEmpty()){
        //     return null;
        // }

        // Collections.sort(list);
        // ListNode dummy = new ListNode(0);
        // ListNode curr= dummy;

        // // building the linkedlist
        // for(Integer val : list){
        //      curr.next = new ListNode(val);
        //      curr = curr.next;
        // }

        // return dummy.next;


        // m2 Recursion 
        int n = lists.length;
        if(n==0){
            return null;
        }

        return partitionAndMerge(0,n-1,lists);

    }
}
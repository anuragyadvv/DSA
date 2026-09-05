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
    public ListNode rotateRight(ListNode head, int k) {

        // Approach - 1 (put all the nodes value in an array and rotate the array by k position )(Imp to understand how to rotate an array by k position)


        // if(head == null || head.next == null){
        //     return head;
        // }

        // int size = 0;
        // ListNode temp = head;
        // while(temp != null){
        //     size++;
        //     temp = temp.next;
        // }

        // int arr[] = new int[size];
        // int i=0;
        // temp = head;

        // while(temp != null){
        //     arr[i] = temp.val;
        //     i++;
        //     temp = temp.next;
        // }

        // // Proper way to rotate an array k times 

        // int n = arr.length;

        // // do normalisation (VVIP)
        //  k = k % n;

        // //1.  reverse whole array
        //  reverse(arr, 0, n-1);
        // //  2. reverse k elements 
        // reverse(arr, 0, k-1);
        // // 3.reverse remaining elements
        // reverse(arr,k, n-1);


        // // now modify the linkedList 
        // temp = head;
        // int j =0;

        // while(temp != null){
        //   temp.val = arr[j];
        //   j++;
        //   temp = temp.next;
        // }

        // return head;




        // Approach -2 (using LinkedList pointer only without extra space )

        if(head == null || head.next == null || k==0){
            return head;
        }

        ListNode tail = head;
        int L = 1 ; // for head

        while(tail.next != null){
            tail = tail.next;
            L++;
        }

        k = k%L;
        if(k==0){
            return head;
        }

        // circular connect 
        tail.next = head;

    //    remaining 
     int remain = L-k;

     ListNode newTail = head;

     for(int c=1; c<remain;c++){
        newTail = newTail.next;
     }

     ListNode newHead = newTail.next;
     newTail.next = null;

     return newHead;

    }

    public void reverse(int arr[], int start, int end){

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
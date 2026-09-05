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

        // Approach - 1 (put all the nodes value in an array and rotate the array by k position )
        if(head == null || head.next == null){
            return head;
        }

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int arr[] = new int[size];
        int i=0;
        temp = head;

        while(temp != null){
            arr[i] = temp.val;
            i++;
            temp = temp.next;
        }

        // Proper way to rotate an array k times 

        int n = arr.length;

        // do normalisation (VVIP)
         k = k % n;

        //1.  reverse whole array
         reverse(arr, 0, n-1);
        //  2. reverse k elements 
        reverse(arr, 0, k-1);
        // 3.reverse remaining elements
        reverse(arr,k, n-1);


        // now modify the linkedList 
        temp = head;
        int j =0;

        while(temp != null){
          temp.val = arr[j];
          j++;
          temp = temp.next;
        }

        return head;

        
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
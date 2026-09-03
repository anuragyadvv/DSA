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
    public void reorderList(ListNode head) {
        

        // Approach 1 
    //     ArrayList<Integer> list = new ArrayList<>();
    //     ListNode temp = head;

    //     while(temp != null){
    //         list.add(temp.val);
    //         temp = temp.next ;
    //     }

    //     int n = list.size();
    //     int result[] = new int[n];
    //     boolean leftTurn = true;
    //     boolean rightTurn = false;
    //     int i= 0;
    //     int j = n-1;
    //     int k=0;

    //     while(i<=j){

    //         if(leftTurn){
    //             result[k] = list.get(i);
    //             i++;
    //             leftTurn = false;
    //             rightTurn = true;
    //         }
    //         else{
    //             result[k] = list.get(j);
    //             j--;
    //             leftTurn = true;
    //             rightTurn = false;
    //         }

    //         k++;
    //     }


    //   temp = head;
    //   for(int num: result){
    //     temp.val = num;
    //     temp= temp.next;
    //   }


    // Approach -2 (done in notes)

    // find mid node( here mid node will be last node of first half )
    ListNode slow = head;
    ListNode fast = head.next;

    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode mid = slow ;

    // Reverse the second half 
    ListNode curr = mid.next;
    mid.next = null;
    ListNode next;
    ListNode prev = null;

    while(curr!=null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    ListNode LH = head;
    ListNode RH = prev;
    ListNode NextL;
    ListNode NextR;

    while(LH != null && RH != null ){
        NextL = LH.next;
        LH.next = RH;
        NextR = RH.next;
        RH.next = NextL;

        LH = NextL;
        RH = NextR;
    }
  
    }
}
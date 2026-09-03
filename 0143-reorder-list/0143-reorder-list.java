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
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next ;
        }

        int n = list.size();
        int result[] = new int[n];
        boolean leftTurn = true;
        boolean rightTurn = false;
        int i= 0;
        int j = n-1;
        int k=0;

        while(i<=j){

            if(leftTurn){
                result[k] = list.get(i);
                i++;
                leftTurn = false;
                rightTurn = true;
            }
            else{
                result[k] = list.get(j);
                j--;
                leftTurn = true;
                rightTurn = false;
            }

            k++;
        }


      temp = head;
      for(int num: result){
        temp.val = num;
        temp= temp.next;
      }

        
    }
}
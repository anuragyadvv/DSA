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
    // method- brute force 
    ArrayList<Integer> list;
   
    public Solution(ListNode head) {
        list = new ArrayList<>();
       


        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int n = list.size();
        // Math.random() returns a double from [0.0, 1.0)
        int random_index = (int) (Math.random()*n);

        return list.get(random_index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
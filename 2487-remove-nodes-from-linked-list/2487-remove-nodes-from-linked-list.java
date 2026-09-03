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
    public ListNode removeNodes(ListNode head) {

        // Approach -1 (using concept of stack and next greater elelemnt  concept of stack)

        // ListNode temp = head;
        // ArrayList<Integer> list = new ArrayList<>();

        // while(temp != null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // int n = list.size();
        // Stack<Integer> s = new Stack<>();
        // int ngr[] = new int[n];

        // s.push(n-1);
        // ngr[n-1] = -1;

        // for(int i= n-2 ;i>=0 ;i--){
        //     int curr = list.get(i);
        //     while(!s.isEmpty() && curr >= list.get(s.peek()) ){
        //         s.pop();
        //     }

        //     if(s.isEmpty()){
        //         ngr[i] = -1;
        //     }else{
        //         ngr[i] = list.get(s.peek());
        //     }

        //     s.push(i);
        // }

        // ListNode dummy = new ListNode(-1);
        // ListNode curr = dummy;

        // for(int i=0;i<n; i++){
        //     if(ngr[i] != -1) continue;

        //     curr.next = new ListNode(list.get(i));
        //     curr = curr.next;
        // }

        // return dummy.next;


        // Approach - 2(using stack only)

        Stack<ListNode> s = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            s.push(curr);
            curr = curr.next;
        }

        curr = s.peek();
        s.pop();
        int maxNode = curr.val;

        ListNode resultHead = new ListNode(curr.val);

        while(!s.isEmpty()){
            curr = s.peek();
            s.pop();

            if(curr.val< maxNode){
                continue;
            }
            else{
                ListNode newNode = new ListNode(curr.val);
                newNode.next = resultHead;
                resultHead = newNode;
                maxNode = curr.val;
            }
        }

        return resultHead;
        
    }
}
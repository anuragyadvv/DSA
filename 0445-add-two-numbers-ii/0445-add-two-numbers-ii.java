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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // approach -1 - store the values of each both the linkedList in  two arrayList and revrse bothe arrayList then perform addition operation and store it is a third linkedList then make a newLinkedList from the new list 

        List<Integer> list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();

        ListNode temp1 = l1;
        ListNode temp2 =l2;

        while(temp1!=null){
            list1.add(temp1.val);
            temp1 = temp1.next;
        }

         while(temp2!=null){
            list2.add(temp2.val);
            temp2 = temp2.next;
        }

           List<Integer>res = new ArrayList<>();

        int n = list1.size();
        int m = list2.size();
        
        int i= n-2;
        int j= m-2;
        int carry =0;
        int rem =0;

        int sum = list1.get(n-1)+list2.get(m-1);
         rem = sum%10;
        res.add(rem);
         carry = sum/10;

     

        while(i>=0 && j>=0){
             sum = list1.get(i)+list2.get(j) + carry;
            rem = sum % 10;
            carry = sum/10;

            res.add(rem);
            
            
            i--;
            j--;
        }

        while(i>=0){
           sum = list1.get(i)+carry;
           rem = sum%10;
           carry = sum/10;
           res.add(rem);
           i--;
        }

        while(j>=0){
            sum = list2.get(j)+carry;
            rem = sum%10;
            carry = sum/10;
            res.add(rem);
            j--;
        }

        if(carry>0){
            res.add(carry);
        }


        Collections.reverse(res);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(Integer x: res){
            curr.next = new ListNode(x);
            curr = curr.next;
        }

        return dummy.next;
    }
}
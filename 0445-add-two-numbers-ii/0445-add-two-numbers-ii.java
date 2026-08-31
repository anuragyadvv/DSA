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

        // List<Integer> list1 = new ArrayList<>();
        // List<Integer>list2 = new ArrayList<>();

        // ListNode temp1 = l1;
        // ListNode temp2 =l2;

        // while(temp1!=null){
        //     list1.add(temp1.val);
        //     temp1 = temp1.next;
        // }

        //  while(temp2!=null){
        //     list2.add(temp2.val);
        //     temp2 = temp2.next;
        // }

        //    List<Integer>res = new ArrayList<>();

        // int n = list1.size();
        // int m = list2.size();
        
        // int i= n-2;
        // int j= m-2;
        // int carry =0;
        // int rem =0;

        // int sum = list1.get(n-1)+list2.get(m-1);
        //  rem = sum%10;
        // res.add(rem);
        //  carry = sum/10;

     

        // while(i>=0 && j>=0){
        //      sum = list1.get(i)+list2.get(j) + carry;
        //     rem = sum % 10;
        //     carry = sum/10;

        //     res.add(rem);
            
            
        //     i--;
        //     j--;
        // }

        // while(i>=0){
        //    sum = list1.get(i)+carry;
        //    rem = sum%10;
        //    carry = sum/10;
        //    res.add(rem);
        //    i--;
        // }

        // while(j>=0){
        //     sum = list2.get(j)+carry;
        //     rem = sum%10;
        //     carry = sum/10;
        //     res.add(rem);
        //     j--;
        // }

        // if(carry>0){
        //     res.add(carry);
        // }


        // Collections.reverse(res);

        // ListNode dummy = new ListNode(-1);
        // ListNode curr = dummy;

        // for(Integer x: res){
        //     curr.next = new ListNode(x);
        //     curr = curr.next;
        // }

        // return dummy.next;



        // Approach - 2 (by reversing the linkedList)
       
    //    reverse the first linkedList with head l1
        ListNode next1;
        ListNode curr1 = l1;
        ListNode prev1 = null;

        while(curr1!=null){
            next1 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1= next1;
        }

        // prev1 will point to head of reversed linkedlist 


//    reverse the second LinkedList with head l2
        ListNode next2;
        ListNode curr2 = l2;
        ListNode prev2 = null;

        while(curr2!=null){
            next2 = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = next2;
        }

        // prev2 will point to head of reversed LinkedList 

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry =0;
        


        while(prev1!=null && prev2!=null){
            int sum = prev1.val +prev2.val + carry;
            int rem = sum%10;
             carry = sum/10;

            curr.next = new ListNode(rem);

            prev1 = prev1.next;
            prev2 = prev2.next;
            curr = curr.next;

        }

        while(prev1!=null){
            int sum = prev1.val + carry;
            int rem = sum %10;
            carry = sum/10;

            curr.next = new ListNode(rem);

            prev1 = prev1.next ;
            curr= curr.next;


        }

         while(prev2!=null){
            int sum = prev2.val + carry;
            int rem = sum %10;
            carry = sum/10;

            curr.next = new ListNode(rem);

            prev2 = prev2.next ;
            curr= curr.next;


        }

        if(carry>0){
            curr.next = new ListNode(carry);
        }


        // now again reverse the  linkedList 

        ListNode next3;
        ListNode curr3 = dummy.next;
        ListNode prev3 = null;

        while(curr3!=null){
            next3 = curr3.next;
            curr3.next = prev3;
            prev3 = curr3;
            curr3 = next3;
        }


        return prev3 ; //head oafter adding 



    }
}
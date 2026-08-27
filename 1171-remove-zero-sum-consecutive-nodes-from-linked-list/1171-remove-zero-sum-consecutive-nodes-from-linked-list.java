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
    public ListNode removeZeroSumSublists(ListNode head) {

    // Brute force 
    //     if(head==null){
    //         return null;
    //     }
    //     if(head.next==null){
    //         return head.val==0? null : head;
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     ListNode temp = head;
    //     while(temp!=null){
    //         list.add(temp.val);
    //         temp = temp.next;
    //     }


    //   for(int i=0;i<list.size();i++){
    //     int currSum =0;
    //     for(int j=i;j<list.size();j++){
    //         currSum += list.get(j);

    //         if(currSum==0){
               
    //            for(int k=j; k>=i;k--){
    //             list.remove(k);
                
    //            }
    //            i=-1; // because again i should start from 0th index  to check other currSum =0
    //            break;
    //         }
    //     }

       
    //   }

    //   ListNode dummy = new ListNode(-1);
    //   ListNode curr = dummy;

    //   for(Integer val : list){
    //     curr.next = new ListNode(val);
    //     curr = curr.next;
    //   }

    //    return dummy.next;


    // optimized  Approach - using HashMap (similar cocept as we have used in subarray sum equals k )


    int prefixSum = 0;

    HashMap<Integer,ListNode> map = new HashMap<>();
     

     ListNode dummyNode = new ListNode(0);

     dummyNode.next = head;

    map.put(0,dummyNode);

    while(head != null){
       prefixSum += head.val;

       if(map.containsKey(prefixSum)){

        ListNode start = map.get(prefixSum);
        ListNode temp = start;
        int currPrefixSum = prefixSum;

        while(temp!=head){
            temp = temp.next;
            currPrefixSum += temp.val;
            if(temp!= head)
            map.remove(currPrefixSum);
        }

        start.next = head.next;
       }
       else{
        map.put(prefixSum, head);
       }

       head = head.next;
    }


   return dummyNode.next;


    }
}
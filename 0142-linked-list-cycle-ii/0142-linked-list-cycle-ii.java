/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        // optimized 

    //     ListNode slow=head;
    //     ListNode fast=head;
    //     boolean isCycle = false;

    //     while(fast!=null && fast.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //         if(slow==fast){
    //             isCycle = true;
    //             break;
    //         }
    //     }

    //     if(isCycle==false) return null;

    //   slow = head;
    //   while(slow!=fast){
    //     slow= slow.next;
    //     fast= fast.next;
    //   }

    //   return slow;


    // Brute force 
    Set<ListNode> set = new HashSet<>();
    ListNode temp = head;
    while(temp!=null){
        if(set.contains(temp)){
            return temp;
        }else{
         set.add(temp);
         temp=temp.next;
        }
    
    }

    return null;

        
    }
}
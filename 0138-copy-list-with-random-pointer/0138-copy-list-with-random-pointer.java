/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {


        // Approach 1 - using hashMap (tc -O(n) and sc - O(n))

    //     if(head == null){
    //         return null;
    //     }

    //     Map<Node,Node> map = new HashMap<>();

    //     Node curr = head; // traverse on original linkedList 
    //     Node prev = null;
    //     Node newHead = null; // head of new linkedList 

    // while(curr!=null){
    //     Node temp = new Node (curr.val);
    //     map.put(curr,temp); // storing in map

    //     if(newHead==null){
    //         newHead = temp;
    //         prev = newHead;
    //     }else{
    //         prev.next = temp;
    //         prev = temp;
    //     }
    //      curr = curr.next;
    // }


    // // fill random pointer 
    // curr = head;
    // Node newCurr = newHead;
    //   while(curr!= null){
    //     if(curr.random == null){
    //         newCurr.random = null;
    //     }
    //     else{
    //         Node randomOriginalNode = curr.random;
    //         newCurr.random = map.get(randomOriginalNode);
    //     }

    //     curr = curr.next;
    //     newCurr = newCurr.next;
    //   }

    //     return newHead;


    // Approach -2 (TC -O(n) and SC-O(1))

    // Insert new nodes in original linkedList
    // put random pointers
    // seperate 

    if(head == null){
        return null;
    }

    // 1. insert the new nodes in between the original linkedlist 
    Node curr = head;
    while(curr!= null){
        Node currNext = curr.next;  //B
        curr.next = new Node(curr.val);   // A->B
        curr.next.next = currNext;  // A->x->B

        curr = currNext;  // curr = B
    }

    // 2. Deep copy of random pointers 
    curr  = head;
    while(curr!= null && curr.next!=null){

        if(curr.random == null){
            curr.next.random = null;
        }else{
            curr.next.random = curr.random.next; 
        }

        curr = curr.next.next;
    }


    // 3. seperate the linkedlist 
    Node newHead = head.next;
    Node newCurr = newHead;
    curr = head;

    while(curr != null && newCurr != null){

        curr.next = curr.next==null? null :  curr.next.next;
        newCurr.next = newCurr.next==null? null : newCurr.next.next;

        curr= curr.next;
        newCurr = newCurr.next;

    }

    
   return newHead;

   
    }
}
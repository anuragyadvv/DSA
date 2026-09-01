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
        // Approach 1 - using hashMap 

        if(head == null){
            return null;
        }

        Map<Node,Node> map = new HashMap<>();

        Node curr = head; // traverse on original linkedList 
        Node prev = null;
        Node newHead = null; // head of new linkedList 

    while(curr!=null){
        Node temp = new Node (curr.val);
        map.put(curr,temp); // storing in map

        if(newHead==null){
            newHead = temp;
            prev = newHead;
        }else{
            prev.next = temp;
            prev = temp;
        }
         curr = curr.next;
    }


    // fill random pointer 
    curr = head;
    Node newCurr = newHead;
      while(curr!= null){
        if(curr.random == null){
            newCurr.random = null;
        }
        else{
            Node randomOriginalNode = curr.random;
            newCurr.random = map.get(randomOriginalNode);
        }

        curr = curr.next;
        newCurr = newCurr.next;
      }

        return newHead;
   
    }
}
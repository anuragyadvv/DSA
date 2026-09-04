class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Brute force - TLE 
        // List<Integer> list = new ArrayList<>();
        // ListNode temp = head;

        // while (temp != null) {
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // // Filter elements into a new list
        // List<Integer> filtered = new ArrayList<>();
        // for (int val : list) {
        //     boolean shouldRemove = false;
        //     for (int num : nums) {
        //         if (val == num) {
        //             shouldRemove = true;
        //             break;
        //         }
        //     }
        //     if (!shouldRemove) {
        //         filtered.add(val);
        //     }
        // }

        // ListNode dummy = new ListNode(-1);
        // ListNode curr = dummy;

        // for (int val : filtered) {
        //     curr.next = new ListNode(val);
        //     curr = curr.next;
        // }

        // return dummy.next;



        // Approach - 2 

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        // Handle the head 
         while( head != null && set.contains(head.val)){
            head = head.next;
         }

         ListNode curr = head;
         while(curr != null && curr.next != null){
              if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
              }
              else{
                curr = curr.next;
              }
         }

         return head;
        
    }
}
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // brute force - store all nodes value in a list then find all the critical points and store their index in another list then sort the list containing index of critical points then find maxDist and minDist and store in an array and return it 

        // ArrayList<Integer> list = new ArrayList<>();
        // ListNode temp = head;
        // while (temp != null) {
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // int size = list.size();

        // ArrayList<Integer> criticalPointIdx = new ArrayList<>();

        // for (int i = 1; i < size - 1; i++) {

        //     //    minima
        //     if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
        //         criticalPointIdx.add(i);
        //     }
        //     //  maxima
        //     if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
        //         criticalPointIdx.add(i);
        //     }
        // }

        // int result[] = new int[2];
        // int maxDist = Integer.MIN_VALUE;

        // Collections.sort(criticalPointIdx);

        // int len = criticalPointIdx.size();

        // if (len >= 2)
        //     maxDist = Math.max(maxDist, (criticalPointIdx.get(len - 1) - criticalPointIdx.get(0)));

        // int minDist = Integer.MAX_VALUE;

        // for (int i = 0; i < len - 1; i++) {
        //     minDist = Math.min(minDist, (criticalPointIdx.get(i + 1) - criticalPointIdx.get(i)));
        // }

        // result[0] = minDist == Integer.MAX_VALUE ? -1 : minDist;
        // result[1] = maxDist == Integer.MIN_VALUE ? -1 : maxDist;

        // return result;

        // approach -2 

        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int idx = 1;

        List<Integer> list = new ArrayList<>();

        while (next != null) {

            if (curr.val < prev.val && curr.val < next.val) {
                list.add(idx);
            }

            if (curr.val > prev.val && curr.val > next.val) {
                list.add(idx);
            }

            prev = curr;
            curr = next;
            next = next.next;

            idx++;

        }

        int result[] = new int[2];
        int maxDist = Integer.MIN_VALUE;

        Collections.sort(list);

        int len = list.size();

        if (len >= 2)
            maxDist = Math.max(maxDist, (list.get(len - 1) - list.get(0)));

        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < len - 1; i++) {
            minDist = Math.min(minDist, (list.get(i + 1) - list.get(i)));
        }

        result[0] = minDist == Integer.MAX_VALUE ? -1 : minDist;
        result[1] = maxDist == Integer.MIN_VALUE ? -1 : maxDist;

        return result;

    }
}
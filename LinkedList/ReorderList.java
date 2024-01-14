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

// higher space complexity used hashmaps
class Solution {
    public void reorderList(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode curr = head;
        int cnt = 0;
        while(curr != null)
        {
            map.put(cnt,curr.val);
            curr = curr.next;
            cnt++;
        }
        int firstIdx = 1;
        int lastIdx = cnt-1;

        ListNode dummy = new ListNode(200);
        dummy.next = head;
        while(firstIdx <= lastIdx)
        {
            head.next = new ListNode (map.get(lastIdx));
            head = head.next;
            if(firstIdx == lastIdx )
                break;  
            head.next = new ListNode (map.get(firstIdx));
            head = head.next;
            firstIdx++;
            lastIdx--;
        }

    }
}

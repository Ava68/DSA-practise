https://leetcode.com/problems/add-two-numbers/

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
        
      
        
     ListNode head = new ListNode( (l1.val + l2.val) % 10 ) ;
        
        
         int carry = (l1.val + l2.val) / 10;
        
         ListNode res  = head;
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null)
        {
            int ans = (l1.val + l2.val + carry) % 10;
            res.next = new ListNode(ans);
            res = res.next;
            
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null)
        {
            int ans = (l1.val + carry) % 10;
            res.next = new ListNode(ans);
            carry = (l1.val + carry) / 10;
            res = res.next;
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            int ans = (l2.val + carry) % 10;
            res.next = new ListNode(ans);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            res = res.next;
        }
        
        if(carry != 0)
            res.next = new ListNode(carry);
        
        return head;
    }
}

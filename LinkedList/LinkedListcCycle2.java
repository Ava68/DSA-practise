https://leetcode.com/problems/linked-list-cycle-ii/
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

Brute Force o(n) space
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        Set<ListNode> set = new HashSet<ListNode>();
        
        
        while(head != null)
        {
            if(!set.contains(head))
            {
                set.add(head);
                
            }
            
            else {
                return head;
                
            }
            
            head = head.next;
        }
        
        return null;
    }
}

Optimal solution o(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                slow = head;
                
                while(slow != null)
                {
                    if(slow == fast )
                        return slow;
                    slow = slow.next;
                    fast = fast.next;
                }
                
                
            }
        }
        
        return null;
    }
}

// intution is to whenever slow and fast pointers become equal then you make slow = head
// increase both slow and fast at same speed and the moment they become equal you return

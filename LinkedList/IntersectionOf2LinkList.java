

Brute Force 

/**
 * Definition for singly-linked list.
 \\
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode>set = new HashSet<ListNode>();
        
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        while(l1 != null)
        {
            set.add(l1);
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            if(set.contains(l2))
                return l2;
            else
                l2 = l2.next;
        }
        
        return null;
        
    }
}

optimal soln

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;
        
        while(dummy1 != null || dummy2 != null)
        {
            if(dummy1 == null)
                dummy1 = headB;
             if(dummy2 == null)
                dummy2 = headA;
            
             if(dummy1 == dummy2)
            {
               return dummy1;
            }
            
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
            
        }
        return null;
    }
}

// here intution is whenever one of the dummy nodes becomnes null
// start it from the head of the other node they will always meet up at their intersection point if it exists.

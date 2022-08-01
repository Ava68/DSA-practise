https://leetcode.com/problems/reverse-linked-list/submissions/

Brute Force


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
    public ListNode reverseList(ListNode head) {
        Stack<Integer>st = new Stack<Integer>();
        
        ListNode curr = head;
        while(curr != null)
        {
            st.push(curr.val);
            curr = curr.next;
        }
        
    
         curr = head;
         
        while(!st.isEmpty())
        {
            
            curr.val = st.pop();
            curr = curr.next;
        }
        
        return head;
    }
}

optimal solution

sc-> o(1)
  
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null)
        {
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        
        return prev;
    }
}

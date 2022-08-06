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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0 )
            return head;
        
        ListNode curr = head;
        int len = 0;
        
        while(curr != null)
        {
            len++;
            curr = curr.next;
        }   
        
        if(len > k)
        {
            int pos = len - k;
           
            curr = head;
            int count = 0;
            
            while( count < pos-1)
            {
                curr = curr.next;
                count++;
            }
            
            ListNode store = curr.next;
            curr.next = null;
            
            ListNode tail = store;
            
            while(tail.next != null)
                tail = tail.next;
            
            tail.next = head;
            head = store;
        }
        
        else if( (len < k) && (k % len != 0) )
        {
            int pos = len - (k % len);    
            curr = head;
            int count = 0;
            
            while( count < pos-1)
            {
                curr = curr.next;
                count++;
            }
            
            ListNode store = curr.next;
            curr.next = null;
            
            ListNode tail = store;
            
            while(tail.next != null)
                tail = tail.next;
            
            tail.next = head;
            head = store;
            
        }
              
        return head;  
    }
}

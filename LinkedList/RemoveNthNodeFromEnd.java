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

tc-> o(2n)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int length = 0; 
        ListNode curr = head;
        
        while(curr != null)
        {
            curr = curr.next;
            length++;
        }
        
        if(length == 1)
            return null;
        
        int num = length - n;
        
        if(length == n)
            return head.next;
        
        int count = 1;  
        curr = head;
        
        while(curr.next !=null && count < num)
        {
            curr = curr.next;
            count++;
        }   
        curr.next = curr.next.next;      
        return head;
    }
}

tc-> o(n)
  

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        dummy.next = head;
        //0->1->2->3->4->5->null
        // we make  a dummy node and out pointers first and second are pointing to this node
        
        for(int i=0; i<n+1 ; i++)
        {
            
            if(first ==null)
                return null;
                
                
            first = first.next;
        }
        
            
        while(first!=null)
        {
            first = first.next;
            second = second.next;
        }
        
 
        second.next = second.next.next;
        
        return dummy.next;
        
    }
}

https://leetcode.com/problems/palindrome-linked-list/submissions/

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

brute force o(n) space

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();
        
        ListNode curr = head;
        
        while(curr != null)
        {
            st.push(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        while(!st.isEmpty())
        {
            if(curr.val != st.pop())
                return false;
            
            curr = curr.next;
        }
        
        return true;
        
    }
}

optimal soln o(1) extra space

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
    public boolean isPalindrome(ListNode head) {
        
        int count = 0;
        ListNode curr = head;
        
        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        
        if(count == 1)
            return true;
        
        if(count % 2 == 0)
        {
            ListNode ptr1 = reverseFirstHalf(head,count/2);
            int countPtr2 = 0;
            
            ListNode ptr2 = ptr1;
            while(countPtr2 < count/2)
            {
                ptr2 = ptr2.next;
                countPtr2++;
            }
            
            System.out.println(ptr2.val);
            
            while(ptr2 != null)
            {
                if(ptr1.val != ptr2.val)
                    return false;
                
                ptr2 = ptr2.next;
                ptr1 = ptr1.next;
            }
        }
        
        else {
            
            ListNode ptr1 = reverseFirstHalf(head,count/2);
            
            int countPtr2 = -1;
            ListNode ptr2 = ptr1;
            while(countPtr2 < count/2  )
            {
                ptr2 = ptr2.next;
                countPtr2++;
            }
            
            while(ptr2 != null)
            {
                if(ptr1.val != ptr2.val)
                    return false;
                ptr2 = ptr2.next;
                ptr1 = ptr1.next;
            }
        }
        
        return true;
    }
    
    public ListNode reverseFirstHalf(ListNode head,int k)
    {
        ListNode prev = null;
        ListNode next = null;
        ListNode rest_head = head;
        ListNode curr = head;
        
        int count = 0;
        
        while(count < k)
        {
            rest_head = rest_head.next;
            count++;
        }
        
        count = 0;
        while(count < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        head.next = rest_head;
        
        return prev;
    }
}

// we need to reverse first half of the link list 

// then we need to check if the length of the entire link list 
        // odd length link list
        // even length link list

// if we have odd lt link list then we need to find the middle of the link list
// and fix the middle then we follow the two pointer approach

// if link list is even after reversing 1 pointer at start
// 1 pointer at mid/2;


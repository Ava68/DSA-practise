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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeHelper(lists,0,lists.length-1);
    }

    public ListNode mergeHelper(ListNode[] lists, int left , int right)
    {
        if(left >= right)
            return lists[left];
        int mid = (left + right) /2;
        ListNode lList = mergeHelper(lists,left,mid);
        ListNode rList = mergeHelper(lists,mid+1,right);
        return merge(lList,rList);
    }

    public ListNode merge(ListNode lList, ListNode rList)
    {
        ListNode dummListHead = new ListNode(101);
        ListNode dummy = dummListHead;
        while(lList != null &&  rList != null)
        {
            if(lList.val <= rList.val)
            {
                dummy.next = new ListNode(lList.val);
                lList = lList.next;
                dummy = dummy.next;
            }
               
            else
            {
                 dummy.next = new ListNode(rList.val);
                 rList = rList.next;
                 dummy = dummy.next;
            }
        }
        while(lList != null)
        {
            dummy.next = new ListNode(lList.val);
            lList = lList.next;
            dummy = dummy.next;

        }
        while(rList != null)
        {
            dummy.next = new ListNode(rList.val);
            rList = rList.next;
            dummy = dummy.next;

        }
     return dummListHead.next;

    }

    
}

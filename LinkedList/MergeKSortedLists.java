https://leetcode.com/problems/merge-k-sorted-lists/description/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        //initializing an empty LinkedList
        ListNode list3 = null;
        for(int i = 0 ; i < lists.length; i ++){
            //passing every LinkedList from the lists and getting the new merged LinkedList
            list3 = merge(lists[i],list3);
        }
        return list3;
    }
    //This is the merge function of the MergeSort Algorithm.
    public ListNode merge(ListNode list1,ListNode list2){
        //Creating the dummy node to keep track of the head node of new linkedList i.e. is list3
        ListNode dummy = new ListNode(-1);
        ListNode list3 = new ListNode(-2);
        dummy.next = list3;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                list3.next = new ListNode(list1.val,null);
                list3 = list3.next;
                list1 = list1.next;
            }else{
                list3.next = new ListNode(list2.val,null);
                list3 = list3.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            list3.next = new ListNode(list1.val,null);
            list3 = list3.next;
            list1 = list1.next;
        }
        while(list2 != null){
            list3.next = new ListNode(list2.val,null);
            list3 = list3.next;
            list2 = list2.next;
        }
        return dummy.next.next;
    }
}

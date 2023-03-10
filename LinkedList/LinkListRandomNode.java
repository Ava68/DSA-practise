https://leetcode.com/problems/linked-list-random-node/description/

class Solution {
    List<Integer>list = new ArrayList<Integer>();
    public Solution(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        int randomValue = list.get(randomIndex);

        return randomValue;
    }
}

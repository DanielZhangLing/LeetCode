package LinkedListCycle141;

/*
 * Given a linked list, determine if it has a cycle in it.
 */

public class LinkedListCycle141 {
	/*
	 * set a slow and a fast
	 */
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast))// set inside can avoid special case only one node and two nodes
                return true;
        }

        return false;
    }
}

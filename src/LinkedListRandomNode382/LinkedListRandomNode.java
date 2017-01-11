package LinkedListRandomNode382;

public class LinkedListRandomNode {
	
	ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        ListNode current = head.next;
        int count = 2;
        while(current!=null){
        	if(0==(int)(Math.random() * count)){
        		res = current.val;
        	}
        	current = current.next;
        	count++;
        }
        return res;
    }
}

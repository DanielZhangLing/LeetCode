package ReverseLinkedList206;

public class ReverseLinkedList {

    public ListNode reverseList2(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
	
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    public ListNode reverse (ListNode B, ListNode A){
        if(B == null){
            return B; 
        }
        ListNode temp = B.next;
        B.next = A;
        return reverse(temp, B);
        
    }
}

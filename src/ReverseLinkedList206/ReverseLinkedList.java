package ReverseLinkedList206;

public class ReverseLinkedList {

    public ListNode reverseList2(ListNode head) {
        if(head==null)
            return null;
        ListNode prev = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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

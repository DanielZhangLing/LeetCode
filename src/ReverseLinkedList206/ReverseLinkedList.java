package ReverseLinkedList206;

public class ReverseLinkedList {

    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        if(head==null)
        return pre;
        ListNode temp = null;
        while(head!=null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
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

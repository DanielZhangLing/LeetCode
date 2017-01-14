package ReverseLinkedList206;

public class ReverseLinkedList {

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

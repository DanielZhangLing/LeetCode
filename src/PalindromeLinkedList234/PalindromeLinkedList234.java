package PalindromeLinkedList234;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;//odd number plus one
        fast = head;
        slow = reverse(slow);
        while(slow!=null){
            if(slow.val!=fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse (ListNode head){
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
}

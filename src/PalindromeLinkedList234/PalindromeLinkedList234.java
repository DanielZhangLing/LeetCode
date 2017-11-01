package PalindromeLinkedList234;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
    	// (1) Move: fast pointer goes to the end, and slow goes to the middle.
        ListNode fast = head, slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;//odd number plus one
        // (3) Compare: run the two pointers head and slow together and compare.
        // fast start from head low go to the end and start from end
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
    
    
    // (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
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

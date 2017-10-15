package AddTwoNumbers2;

/**
 * Created by LingZhang on 5/31/17.
 */

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
<<<<<<< Updated upstream
    	// we need to record the previous one so when we create the current one we can link them
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        // the initial head is the previous of the first one
        return head.next;
=======
        ListNode result = new ListNode(0); // node before result
        ListNode cur = result;
        int flag = 0;
        while(l1!=null||l2!=null){// both list shift
            int sum = 0;
            if(l1!=null){
                sum+= l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+= l2.val;
                l2 = l2.next;
            }
            sum+= flag;
            ListNode temp = new ListNode(sum%10);
            flag = sum/10; //update flag
            cur.next = temp;
            cur = temp;
        }
        if(flag!=0){// last node if exists
            ListNode temp = new ListNode(1);
            cur.next = temp;
        }
        return result.next;


>>>>>>> Stashed changes
    }
}

package AddTwoNumbers2;

/**
 * Created by LingZhang on 5/31/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int flag = 0;
        while(l1!=null||l2!=null){
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
            flag = sum/10;
            cur.next = temp;
            cur = temp;
        }
        if(flag!=0){
            ListNode temp = new ListNode(1);
            cur.next = temp;
        }
        return result.next;


    }
}

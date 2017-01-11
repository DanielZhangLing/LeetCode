package AddTwoNumbersII445;

import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
    	Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();
    	while (l1!=null){
    		s1.push(l1.val);
    		l1=l1.next;
    	}
    	
    	while (l2!=null){
    		s2.push(l2.val);
    		l2=l2.next;
    	}
    	
    	ListNode res = new ListNode(0);
    	
    	int flag = 0;
    	
    	while(!s1.isEmpty()||!s2.isEmpty()){
    		int sum = 0;
    		if(!s1.isEmpty())
    			sum+= s1.pop();
    		if(!s2.isEmpty())
    			sum+= s2.pop();
    		
    		res.val = (sum+flag)%10;
    		flag = (sum+flag)/10;
    		ListNode front = new ListNode(flag);
    		front.next = res;
    		res = front;
    	}
    	
    	return res.val>0?res:res.next;
    }
    
    public static void main(String[] args){
    	
    }
}

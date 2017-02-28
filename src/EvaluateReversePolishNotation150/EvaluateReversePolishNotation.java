package EvaluateReversePolishNotation150;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	   public int evalRPN(String[] tokens) {
	        int a, b;
	        Stack<Integer> operand = new Stack<Integer>();
	        for(String token: tokens){
	            if(token.equals("+"))
	                operand.push(operand.pop()+operand.pop());
	            else if(token.equals("-")){
	                a = operand.pop();
	                b = operand.pop();
	                operand.push(b-a);
	            }
	            else if(token.equals("*"))
	                operand.push(operand.pop()*operand.pop());
	            else if(token.equals("/")){
	                a = operand.pop();
	                b = operand.pop();
	                operand.push(b/a);
	            }
	            else operand.push(Integer.parseInt(token));
	        }
	        return operand.pop();
	    }
}

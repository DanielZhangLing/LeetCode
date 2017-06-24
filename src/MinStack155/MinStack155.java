package MinStack155;

import java.util.Stack;

public class MinStack155 {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack155() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.empty())
            minStack.push(number);
        else{
            minStack.push(Math.min(minStack.peek(), number));
        }
    }

    public int pop() {
        // write your code here
        if(!minStack.empty())
            minStack.pop();
        if(!stack.empty()){
            return stack.pop();
        }
        else
            return -1;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}

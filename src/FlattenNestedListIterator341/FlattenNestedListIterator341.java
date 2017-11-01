package FlattenNestedListIterator341;

public class FlattenNestedListIterator341 {
	/*
	 * In the constructor, we push all the nestedList into the stack from back to front,
	 *  so when we pop the stack, it returns the very first element. 
	 *  Second, in the hasNext() function, we peek the first element in stack currently,
	 *   and if it is an Integer, we will return true and pop the element.
	 *    If it is a list, we will further flatten it.
	 *     This is iterative version of flatting the nested list.
	 *      Again, we need to iterate from the back to front of the list.
	 */
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}



/**
 * I keep the current progress in a stack.
 *  My hasNext tries to find an integer. My next returns it and moves on.
 *   I call hasNext in next because hasNext is optional.
 *    Some user of the iterator might call only next and never hasNext,
 *     e.g., if they know how many integers are in the structure or 
 *     if they want to handle the ending with exception handling.
 * @author LingZhang
 *
 */
public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }
    
    private Stack<ListIterator<NestedInteger>> lists;
}

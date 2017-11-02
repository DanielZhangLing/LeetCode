package RemoveInvalidParentheses302;

/**
 * The idea is straightforward, with the input string s, 
 * we generate all possible states by removing one ( or ), 
 * check if they are valid, if found valid ones on the current level,
 *  put them to the final result list and we are done, otherwise, 
 *  add them to a queue and carry on to the next level.

The good thing of using BFS is that we can guarantee the number of parentheses that need to be removed is minimal,
 also no recursion call is needed in BFS.
 On the first level, there's only one string which is the input string s,
  let's say the length of it is n, to check whether it's valid, 
  we need O(n) time. On the second level, we remove one ( or ) from the first level,
   so there are C(n, n-1) new strings, each of them has n-1 characters,
    and for each string, we need to check whether it's valid or not,
     thus the total time complexity on this level is (n-1) x C(n, n-1). 
     Come to the third level, total time complexity is (n-2) x C(n, n-2), 
     so on and so forth...

Finally we have this formula:

T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
 * @author Daniel
 *
 */
public class RemoveInvalidParentheses302 {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		// sanity check
		if (s == null)
			return res;

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		// initialize
		queue.add(s);
		visited.add(s);

		boolean found = false;

		while (!queue.isEmpty()) {
			s = queue.poll();

			if (isValid(s)) {
				// found an answer, add to the result
				res.add(s);
				found = true;
			}

			if (found)
				continue;

			// generate all possible states
			for (int i = 0; i < s.length(); i++) {
				// we only try to remove left or right paren
				if (s.charAt(i) != '(' && s.charAt(i) != ')')
					continue;

				String t = s.substring(0, i) + s.substring(i + 1);

				if (!visited.contains(t)) {
					// for each state, if it's not visited, add it to the queue
					queue.add(t);
					visited.add(t);
				}
			}
		}

		return res;
	}

	// helper function checks if string s contains valid parantheses
	boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}
	
	
	
	
	
	
	/**
	 * The first observation is when we want to remove a ')' or '('
	 *  from several consecutive ones we only remove the first one, 
	 *  because remove any one the result will be the same. For example

"())" ---> "()"
only remove the first one of '))'

The second observation is when we remove a character 
it must behind it's parent removal position. For example

we need remove 2 from "(())(("
we want to remove positions combination i,j with no duplicate
so we let i < j then it will not generate duplicate combinations
in practice, we record the position i and put it in to queue
which is then polled out and used as the starting point of the next removal

A third observation is if the previous step we removed a "(",
 we should never remove a ")" in the following steps.
  This is obvious since otherwise we could just save these two removals 
  and still be valid with less removals. With this observation
   all the possible removals will be something like this

")))))))))((((((((("
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses(String s) {
	    if (isValid(s))
	        return Collections.singletonList(s);
	    List<String> ans = new ArrayList<>();
	    //The queue only contains invalid middle steps
	    Queue<Tuple> queue = new LinkedList<>();
	    //The 3-Tuple is (string, startIndex, lastRemovedChar)
	    queue.add(new Tuple(s, 0, ')'));
	    while (!queue.isEmpty()) {
	        Tuple x = queue.poll();
	        //Observation 2, start from last removal position
	        for (int i = x.start; i < x.string.length(); ++i) {
	            char ch = x.string.charAt(i);
	            //Not parentheses
	            if (ch != '(' && ch != ')') continue;
	            //Observation 1, do not repeatedly remove from consecutive ones
	            if (i != x.start && x.string.charAt(i - 1) == ch) continue;
	            //Observation 3, do not remove a pair of valid parentheses
	            if (x.removed == '(' && ch == ')') continue;
	            String t = x.string.substring(0, i) + x.string.substring(i + 1);
	            //Check isValid before add
	            if (isValid(t))
	                ans.add(t);
	            //Avoid adding leaf level strings
	            else if (ans.isEmpty())
	                queue.add(new Tuple(t, i, ch));
	        }
	    }
	    return ans;
	}

	public static boolean isValid(String s) {
	    int count = 0;
	    for (int i = 0; i < s.length(); ++i) {
	        char c = s.charAt(i);
	        if (c == '(') ++count;
	        if (c == ')' && count-- == 0) return false;
	    }
	    return count == 0;
	}

	private class Tuple {
	    public final String string;
	    public final int start;
	    public final char removed;

	    public Tuple(String string, int start, char removed) {
	        this.string = string;
	        this.start = start;
	        this.removed = removed;
	    }
	}
}

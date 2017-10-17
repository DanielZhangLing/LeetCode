package WordBreak139;

import java.util.ArrayList;
import java.util.List;

/**
 * dp, s(i) available up to now, for s(i) check all the s(i)-word from dicts
 */
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    for(String wd: wordDict)
        set.add(wd);
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;
    for(int i = 1; i<s.length()+1; i++){
        for(String wd: set){
            if(wd.length()<=i){
                if(dp[i-wd.length()]&&wd.equals(s.substring(i-wd.length(),i))){
                    dp[i] = true;
                    break;                    
                }
            }
        }
    }
    return dp[s.length()];
}

/**
 * dp , s(i) available up to now, for s(i) check all the 0-j and if j-i in dicts
 */
public boolean wordBreak(String s, Set<String> dict) {
    
    boolean[] f = new boolean[s.length() + 1];
    
    f[0] = true;
    for(int i=1; i <= s.length(); i++){
        for(int j=0; j < i; j++){
            if(f[j] && dict.contains(s.substring(j, i))){
                f[i] = true;
                break;
            }
        }
    }
    
    return f[s.length()];
}

/**
 * bfs each step is a word in dict
 * iterate all word in dict for each step
 */
public static boolean wordBreak(String s, List<String> wordDict) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    q.offer(0);
    while(!q.isEmpty()){
        int cur = q.poll();
        for(String wd: wordDict){
            int end = cur+wd.length();// tail of this step
            if(visited.contains(end))
                continue;
            if(end<=s.length()){
                if(wd.equals(s.substring(cur, end))){
                    if(end==s.length())
                        return true;
                    q.offer(end);
                    visited.add(end);
                }
            }
            
        }
    }
    return false;
}

/**
 * bfs
 */
public boolean wordBreak(String s, Set<String> dict) {
    if (dict.contains(s)) return true;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(0);
    // use a set to record checked index to avoid repeated work.
    // This is the key to reduce the running time to O(N^2).
    Set<Integer> visited = new HashSet<Integer>();
    visited.add(0);
    while (!queue.isEmpty()) {
        int curIdx = queue.poll();
        for (int i = curIdx+1; i <= s.length(); i++) {
            if (visited.contains(i)) continue;
            if (dict.contains(s.substring(curIdx, i))) {
                if (i == s.length()) return true;
                queue.offer(i);
                visited.add(i);
            }
        }
    }
    return false;
}


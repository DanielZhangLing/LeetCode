package AssignCookies455;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        
    	int count = 0;
    	int j = 0;
    	Arrays.sort(g);
    	Arrays.sort(s);
    	for(int i=0;i<g.length;i++)
    		for(;j<s.length;j++)
    			if(g[i]<=s[j]){
    				count++;
    				j++;
    				break;
    			}
    	return count;
    }
    
    public static void main(String[] args){
    	int[] g = {1,2};
    	int[] s = {1,2,3};
    	System.out.println(findContentChildren(g,s));
    }
}
